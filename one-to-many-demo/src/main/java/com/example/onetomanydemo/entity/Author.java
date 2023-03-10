package com.example.onetomanydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private int id;
    private String name;

   // @JoinTable(name = "written_book")
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "author")

    private List<Book> books = new ArrayList<>();

    public void removeBook(Book book){
        book.setAuthor(null);        //  *Utility Class* ,,, cause of Bi-directional
        books.remove(book);
    }

    public void addBook(Book book){
        book.setAuthor(this);        //  *Utility class* ,,, cause of Bi-directional
        this.books.add(book);
    }

}
