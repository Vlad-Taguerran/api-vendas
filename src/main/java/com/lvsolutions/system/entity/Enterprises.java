package com.lvsolutions.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Enterprises {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String cnpj;
//    @OneToOne(mappedBy = "enterprise")
//    private Customers customers;
}
