package com.example.productorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cus_product_order")
public class CustomerOrderHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private CustomerOrder customerOrder;

    public CustomerOrderHasProduct(){

    }

    public CustomerOrderHasProduct(int id) {
        this.id = id;
    }
}
