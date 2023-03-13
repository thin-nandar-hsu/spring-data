package com.example.productorderway2.entiy;

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
    private String email;
    private String phone;
    private String address;
    private  String city;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addOrder(CustomerOrder customerOrder){
        this.customerOrders.add(customerOrder);
        customerOrder.setCustomer(this);
    }

    public Customer(){

    }

    public Customer(String name, String email, String phone, String address, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}
