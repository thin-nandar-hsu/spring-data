package com.example.productorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> spring-data/master
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
<<<<<<< HEAD
//    private LocalDate date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CustomerOrderHasProduct> customerOrderHasProducts = new ArrayList<>();

    public void addId(CustomerOrderHasProduct customerOrderHasProduct){
        customerOrderHasProduct.setProduct(this);
        this.customerOrderHasProducts.add(customerOrderHasProduct);
=======
    private Date date;

    @OneToMany
    private List<CustomerOrederHasProduct> customerOrederHasProducts = new ArrayList<>();

    public void addId(CustomerOrederHasProduct customerOrederHasProduct){

        this.customerOrederHasProducts.add(customerOrederHasProduct);
>>>>>>> spring-data/master
    }

    public Product(){

    }

<<<<<<< HEAD
    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
=======
    public Product(String name, int price, String description, Date date) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.date = date;
>>>>>>> spring-data/master
    }
}
