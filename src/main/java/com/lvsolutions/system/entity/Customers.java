package com.lvsolutions.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lvsolutions.system.entity.euns.CustomersType;
import com.lvsolutions.system.entity.euns.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "customers")
@SoftDelete
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition =  "VARCHAR(255) DEFAULT 'Novo'", name = "status")
    private CustomerStatus status;
    @Column
    private String cnpj;
    @Column
    private String municipal_code;
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    private List<Contacts> contacts;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "type")
    private CustomersType type;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

}
