package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;
    private String type;
    private int totalNo;

    @OneToOne(mappedBy = "animal")
    private Cage cage;

    //@JoinTable(name = "animal_cat")
    @ManyToOne
    private Category category;

    @JoinTable(name = "foods")
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<FoodItem> foodItem =new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.getAnimals();
        this.foodItem.add(foodItem);
    }

    public Animal(){

    }
    public Animal(String type, int totalNo) {
        this.type = type;
        this.totalNo = totalNo;
    }


}
