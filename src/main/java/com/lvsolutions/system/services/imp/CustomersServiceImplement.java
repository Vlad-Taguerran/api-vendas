package com.lvsolutions.system.services.imp;

import com.lvsolutions.system.controllerAdvice.ResourceNotFoundException;
import com.lvsolutions.system.dto.Customers.CustomerDto;
import com.lvsolutions.system.dto.Customers.CustomerStatusDTO;
import com.lvsolutions.system.dto.Customers.PostCustomersDto;
import com.lvsolutions.system.entity.Customers;
import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.entity.euns.CustomerStatus;
import com.lvsolutions.system.repository.CustomersRepository;
import com.lvsolutions.system.repository.UserRepository;
import com.lvsolutions.system.services.CustomersService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class CustomersServiceImplement implements CustomersService {

@Autowired
private CustomersRepository customersRepository;
@Autowired
private UserRepository userRepository;

    public ResponseEntity<Customers> addCustomers(PostCustomersDto dto, Users user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Customers customers = new Customers();

            Customers customer_return = null;
            if (auth != null) {
                BeanUtils.copyProperties(dto, customers);
                Users _user = userRepository.findById(user.getId()).orElse(null);
                customers.setUser(_user);
                customer_return = customersRepository.save(customers);
                assert _user != null;
                _user.getCustomers().add(customer_return);
                userRepository.save(_user);
            }

            return ResponseEntity.ok().body(customer_return);
        } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    public ResponseEntity<Customers> updateCustomers(PostCustomersDto dto, UUID uuid) {
    Customers customer =   customersRepository.findById(uuid).orElseThrow(()-> new ResourceNotFoundException("Customers not found"));
        BeanUtils.copyProperties(dto, customer);
        customersRepository.save(customer);

    return ResponseEntity.ok(customer);
    }

    public CustomerDto changeCustomerStatus(UUID id, CustomerStatus status){

       Customers customer = customersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customers not found"));
        customer.setStatus(status);
       Customers toDto = customersRepository.save(customer);
        return new CustomerDto(toDto);
    }
    public ResponseEntity<String> deleteCustomers(UUID id) {
         customersRepository.removeCustomersById(id);
        return ResponseEntity.ok("Deletado com sucesso !");
    }


    public ResponseEntity<List<Customers>> listCustomers(Users user) {
       List<Customers> customersList = customersRepository.findAllByUserId(user.getId());
        if(!customersList.isEmpty()){
            return  ResponseEntity.ok(customersList);
        }
        return  ResponseEntity.noContent().build();
    }

    public List<CustomerStatusDTO> loadCustomersStatus(Users user) {
       List<CustomerStatusDTO> customerStatusDTOS  = customersRepository.countStatusByUser(user.getId());

       return customerStatusDTOS;
    }
}
