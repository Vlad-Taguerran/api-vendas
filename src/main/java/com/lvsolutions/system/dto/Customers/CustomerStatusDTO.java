package com.lvsolutions.system.dto.Customers;

import com.lvsolutions.system.entity.euns.CustomerStatus;

public record CustomerStatusDTO(CustomerStatus status, Long count) {
}
