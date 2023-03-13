package com.example.productorderway2.entiy;

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

    @ManyToMany(mappedBy = "customerOrders")
    private List<Product> products= new ArrayList<>();

    public void addProduct(Product product){
        this.products.add(product);
    }

    public CustomerOrder(){

    }

    public CustomerOrder(int amount, LocalDateTime time, int confirmNum) {
        this.amount = amount;
        this.time = time;
        this.confirmNum = confirmNum;
    }
}
