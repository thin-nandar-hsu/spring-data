package com.example.productorder.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

>>>>>>> spring-data/master
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
<<<<<<< HEAD
    private String phone;
    private String address;
    private  String city;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addOrder(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        this.customerOrders.add(customerOrder);
    }
=======
>>>>>>> spring-data/master

    public Customer(){

    }

<<<<<<< HEAD
    public Customer(String name, String email, String phone, String address, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
=======
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
>>>>>>> spring-data/master
    }
}
