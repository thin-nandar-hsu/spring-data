package com.example.productorderway2.entiy;

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

    public void addProducts(Product product){
        this.products.add(product);
        product.setCategory(this);
    }


    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }
}
