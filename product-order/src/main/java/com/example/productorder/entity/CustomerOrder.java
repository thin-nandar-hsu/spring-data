package com.example.productorder.entity;

<<<<<<< HEAD
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
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
>>>>>>> spring-data/master
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
<<<<<<< HEAD
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


=======

    public CustomerOrder(){

    }

    public CustomerOrder(int amount) {
        this.amount = amount;
    }
}
>>>>>>> spring-data/master
