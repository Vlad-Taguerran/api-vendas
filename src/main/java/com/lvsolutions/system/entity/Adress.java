package com.lvsolutions.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.geo.Point;

import java.util.UUID;

@Data
@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zip;
    @Column
    private String country;

    @Column(name = "locationpoint", columnDefinition = "POINT")
    private Point locationPoint;
}
