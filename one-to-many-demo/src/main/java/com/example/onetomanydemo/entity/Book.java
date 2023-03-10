package com.example.onetomanydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private int id;
    private String title;
    private double price;
    private String gender;

    // Owner table has @JoinTable is cause of *Optional cases*
    @JoinTable(name = "book_author" ,
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "bookId"),
             inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "authorId"))
    @ManyToOne
    private Author author;

    public Book(){

    }

    public Book(String title, double price, String gender) {
        this.title = title;
        this.price = price;
        this.gender = gender;
    }
}
