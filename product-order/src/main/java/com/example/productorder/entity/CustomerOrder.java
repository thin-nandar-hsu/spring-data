package com.example.productorder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
   private LocalDateTime time;
    private int confirmNum;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderHasProduct> customerOrderHasProducts = new ArrayList<>();

    public void addId(CustomerOrderHasProduct customerOrderHasProduct){
        customerOrderHasProduct.setCustomerOrder(this);
        this.customerOrderHasProducts.add(customerOrderHasProduct);
    }


    public CustomerOrder() {

    }

    public CustomerOrder(int amount, LocalDateTime time, int confirmNum, List<CustomerOrderHasProduct> customerOrderHasProducts) {
        this.amount = amount;
        this.time = time;
        this.confirmNum = confirmNum;
        this.customerOrderHasProducts = customerOrderHasProducts;
    }


}


