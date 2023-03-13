package com.example.productorder.entity;


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
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        product.setCategory(this);
        this.products.add(product);
    }

    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }
=======
public class Category {
>>>>>>> spring-data/master
}
