package com.example.manytomanydemo.entity;

import com.example.manytomanydemo.IdClass;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Subject extends IdClass {
    private String name;
    private int duration;
    private int price;

    //@JoinTable(name = "course")
    @ManyToMany(mappedBy = "subject")
    private List<Student> student= new ArrayList<>();

    public void addStu(Student student){
        this.student.add(student);
    }


    public Subject(){

    }

    public Subject(String name, int duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }
}
