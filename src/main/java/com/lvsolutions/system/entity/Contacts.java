package com.lvsolutions.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@Getter
@Setter
@SoftDelete
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column
    private String first_phone;
    @Column
    private String second_phone;
    @Column(unique = true)
    private String email;
    @Column
    private String position;
    @Column(name = "anotation", columnDefinition = "TEXT")
    private String anotation;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "customer_id",referencedColumnName = "id", nullable = false)
    private Customers customer;


}
