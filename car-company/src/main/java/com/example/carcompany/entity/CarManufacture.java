package com.example.carcompany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CarManufacture extends Company{

    private int numOfEmployees;

    @OneToOne(mappedBy = "carManufacture")
    private Car car;

    public CarManufacture(){

    }



    public CarManufacture(String name, Address address, int numOfEmployees) {
        super(name, address);
        this.numOfEmployees = numOfEmployees;
    }
}
