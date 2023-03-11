package com.example.productorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;
    private Date date;

    @OneToMany
    private List<CustomerOrederHasProduct> customerOrederHasProducts = new ArrayList<>();

    public void addId(CustomerOrederHasProduct customerOrederHasProduct){

        this.customerOrederHasProducts.add(customerOrederHasProduct);
    }

    public Product(){

    }

    public Product(String name, int price, String description, Date date) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.date = date;
    }
}
