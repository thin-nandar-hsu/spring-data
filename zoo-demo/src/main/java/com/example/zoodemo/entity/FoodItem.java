package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "fooditem")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    private String name;
    private int qty;

    @ManyToMany(mappedBy = "foodItem")
    private List<Animal> animals = new ArrayList<>();

    @ManyToOne
    private Supplier supplier;

    public FoodItem(){

    }

    public FoodItem(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }
}
