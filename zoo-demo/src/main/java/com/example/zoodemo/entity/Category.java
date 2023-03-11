package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;
    private String type;

    @OneToMany( mappedBy = "category")
    private List<Animal> animal = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animal.setCategory(this);
        this.animal.add(animal);
    }




    public Category() {

    }




    public Category(String type) {
        this.type = type;
    }

}
