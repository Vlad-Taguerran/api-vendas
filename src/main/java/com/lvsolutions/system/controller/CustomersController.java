package com.lvsolutions.system.controller;

import com.lvsolutions.system.dto.Customers.CustomerDto;
import com.lvsolutions.system.dto.Customers.CustomerStatusDTO;
import com.lvsolutions.system.dto.Customers.PostCustomersDto;
import com.lvsolutions.system.entity.Customers;
import com.lvsolutions.system.entity.Users;
import com.lvsolutions.system.entity.euns.CustomerStatus;
import com.lvsolutions.system.services.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @PostMapping
    public ResponseEntity<Customers> addCustomers(@RequestBody PostCustomersDto dto, @AuthenticationPrincipal Users users){
        return customersService.addCustomers(dto, users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@RequestBody PostCustomersDto dto, @PathVariable UUID id){
        return customersService.updateCustomers(dto,id);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> changeStatus(@PathVariable UUID id, @RequestBody PostCustomersDto status){

        CustomerDto customerDto = customersService.changeCustomerStatus(id,status.status());

       return ResponseEntity.ok().body(customerDto);

    }
    @GetMapping()
    public ResponseEntity<List<Customers>> getCustomers(@AuthenticationPrincipal Users users){
        return customersService.listCustomers(users);
    }
    @GetMapping("/status")
    public ResponseEntity<List<CustomerStatusDTO>> loadCustomersStatus(@AuthenticationPrincipal Users user){
       List<CustomerStatusDTO> customerStatus = customersService.loadCustomersStatus(user);

       System.out.println(customerStatus);
       return ResponseEntity.ok(customerStatus);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam UUID id){
        return  customersService.deleteCustomers(id);
    }
}
