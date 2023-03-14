package com.example.carcompany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InsuranceCompany extends Company{

    private int rating;


    @JoinTable(name = "car_insurance" ,
            joinColumns = @JoinColumn(name = "insurance_id",referencedColumnName = "com_id"),
            inverseJoinColumns = @JoinColumn(name = "insurance_car_id",referencedColumnName = "car_id"))
    @ManyToOne
    private Car car;


    public InsuranceCompany(){

    }

    public InsuranceCompany(String name, Address address, int rating) {
        super(name, address);
        this.rating = rating;

    }
}
