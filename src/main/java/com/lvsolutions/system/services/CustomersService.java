package com.lvsolutions.system.services;

import com.lvsolutions.system.dto.Customers.CustomerDto;
import com.lvsolutions.system.dto.Customers.CustomerStatusDTO;
import com.lvsolutions.system.dto.Customers.PostCustomersDto;
import com.lvsolutions.system.entity.Customers;
import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.entity.euns.CustomerStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomersService {

    public ResponseEntity<Customers> addCustomers(PostCustomersDto dto, Users users);
    public ResponseEntity<Customers> updateCustomers(PostCustomersDto dto, UUID uuid);
    public CustomerDto changeCustomerStatus(UUID id, CustomerStatus status);
    public ResponseEntity<String> deleteCustomers(UUID id);
    public ResponseEntity<List<Customers>> listCustomers(Users user);
    public List<CustomerStatusDTO> loadCustomersStatus(Users user);

}
