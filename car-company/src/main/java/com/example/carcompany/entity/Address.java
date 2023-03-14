package com.example.carcompany.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

    private String city;
    private String street;

    public Address(){

    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
