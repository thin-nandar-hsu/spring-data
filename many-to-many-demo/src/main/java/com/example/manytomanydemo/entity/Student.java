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
public class Student extends IdClass {
    private String firstName;
    private String lastName;
    private String email;


    @JoinTable(name = "course")   // in Bi-Directional , you want to change the JoinTable name --> @JoinTable must locate in
                                  // *no mappedBy annotation* side , in other way must locate in Owner Class side
    @ManyToMany(cascade = CascadeType.PERSIST)
     private List <Subject> subject= new ArrayList<>();

    public void addSubj(Subject subject){
<<<<<<< HEAD
        subject.getStudents().add(this);
=======
        subject.getStudent().add(this);
>>>>>>> spring-data/master
        this.subject.add(subject);
      }

    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
