package com.example.onetoonedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String streetName;
    private String streetNumber;
    private String city;


    // mappedBy must stay in not-owner class
    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address(){

    }

    public Address(String streetName, String streetNumber, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
    }
}
