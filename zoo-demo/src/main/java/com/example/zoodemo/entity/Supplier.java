package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supId;
    private String supName;
    private String contact;
    private String address;

    @OneToMany( mappedBy = "supplier")
    private List<FoodItem> foodItems= new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.setSupplier(this);
        this.foodItems.add(foodItem);
    }

    public Supplier(){

    }

    public Supplier(String supName, String contact, String address) {
        this.supName = supName;
        this.contact = contact;
        this.address = address;
    }
}
