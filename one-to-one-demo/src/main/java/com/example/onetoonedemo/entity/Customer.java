package com.example.onetoonedemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;


    // Owner is Customer table
    @JoinColumn(name = "address_fk")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Customer(){

    }

    public Customer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
