package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cage_id;
    private String cageNo;
    private String location;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Animal animal;

    public Cage(){

    }

    public Cage(String cageNo, String location) {
        this.cageNo = cageNo;
        this.location = location;
    }
}
