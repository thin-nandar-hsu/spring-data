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

//    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CustomerOrderHasProduct> customerOrderHasProducts = new ArrayList<>();

    public void addId(CustomerOrderHasProduct customerOrderHasProduct) {
        customerOrderHasProduct.setProduct(this);
        this.customerOrderHasProducts.add(customerOrderHasProduct);
    }

    public Product(){

    }

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
