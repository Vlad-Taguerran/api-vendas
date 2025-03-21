package com.lvsolutions.system.dto.Customers;

import com.lvsolutions.system.entity.euns.CustomersType;
import com.lvsolutions.system.entity.euns.CustomerStatus;

public record PostCustomersDto(
        String name,
       CustomerStatus status,
        String cnpj,
        String municipal_code,
        CustomersType type

) {
}
