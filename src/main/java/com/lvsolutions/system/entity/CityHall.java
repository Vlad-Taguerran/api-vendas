package com.lvsolutions.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CityHall {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String municipal_code;

//
//    @OneToOne(mappedBy = "cityHall")
//    private Customers customers;
}
