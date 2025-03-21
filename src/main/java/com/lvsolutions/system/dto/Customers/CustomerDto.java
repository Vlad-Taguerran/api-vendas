package com.lvsolutions.system.dto.Customers;

import com.lvsolutions.system.entity.Adress;
import com.lvsolutions.system.entity.Contacts;
import com.lvsolutions.system.entity.Customers;
import com.lvsolutions.system.entity.euns.CustomerStatus;
import com.lvsolutions.system.entity.euns.CustomersType;

import java.util.List;
import java.util.UUID;

public record CustomerDto(
        UUID id,
        String name,
        CustomerStatus status,
        String cnpj,
        String municipal_code,
        CustomersType type,
        List<Contacts> contacts) {
    public CustomerDto(Customers customers) {
        this(customers.getId(),
                customers.getName(),
                customers.getStatus(),
                customers.getCnpj(),
                customers.getMunicipal_code(),
                customers.getType(),
                customers.getContacts());
    }

}
