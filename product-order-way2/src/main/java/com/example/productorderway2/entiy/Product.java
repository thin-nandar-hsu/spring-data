package com.example.productorderway2.entiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @JoinTable(name ="product_order")
    @ManyToMany
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addCusOrder(CustomerOrder customerOrder){
        this.customerOrders.add(customerOrder);
        customerOrder.getProducts().add(this);
    }


    public Product(){

    }

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
