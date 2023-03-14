package com.example.carcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;
    private String name;
    private String dob;

    @JoinColumn(name = "car_owner")
    @ManyToOne
    private Car carOwner;


    @JoinTable(name = "car_driver" ,
            joinColumns = @JoinColumn(name = "driver_id",referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id",referencedColumnName = "car_id"))
    @ManyToOne
    private Car carDriver;



    public Person(){

    }

    public Person(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }
}
