package com.example.springjpaelementcollectiontables.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nrc;

    public Customer(){

    }

    public Customer(String name, String nrc) {
        this.name = name;
        this.nrc = nrc;
    }

//    @CollectionTable(name = "customer_phone")
//    @ElementCollection     // ElementCollection can accept both String and Embeddable Class
//    private List<String> phoneNumber = new ArrayList<>();

    @CollectionTable(name = "customer_phone")
    @ElementCollection
    private List<Phone> phones = new ArrayList<>();
//
    @CollectionTable(name = "customer_email")
    @ElementCollection
    private List<String> emails = new ArrayList<>();
    @ElementCollection
    private List<String> addresses = new ArrayList<>();

    public void addPhone(Phone phone){
        phones.add(phone);
    }

    public void addEmail(String email){
        this.emails.add(email);
    }

    public void addAddress(String address){
        this.addresses.add(address);
    }
}
