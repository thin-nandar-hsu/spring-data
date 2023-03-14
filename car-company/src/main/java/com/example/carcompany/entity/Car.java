package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    private String model;
    private String made;
    private LocalDate year;
    private int millage;


    @OneToOne
    private CarManufacture carManufacture;


    @OneToMany(mappedBy = "car")
    private List<InsuranceCompany> insuranceCompanies = new ArrayList<>();

    public void addInsurance(InsuranceCompany insuranceCompany){
        this.insuranceCompanies.add(insuranceCompany);
        insuranceCompany.setCar(this);
    }


   @OneToMany (mappedBy = "carOwner")
    private List<Person> people=new ArrayList<>();

    public void addOwner(Person owner){
        this.people.add(owner);
        owner.setCarOwner(this);
    }


   @OneToMany(mappedBy = "carDriver")
   private List<Person> personList = new ArrayList<>();

    public void addDriver(Person driver){
        this.personList.add(driver);
        driver.setCarDriver(this);
    }

    public Car(){

    }

    public Car(String model, String made, LocalDate year, int millage) {
        this.model = model;
        this.made = made;
        this.year = year;
        this.millage = millage;
    }
}
