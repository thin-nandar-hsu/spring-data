package com.example.zoodemo;

import com.example.zoodemo.service.AnimalService;
import com.example.zoodemo.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooDemoApplication implements CommandLineRunner {

    @Autowired
    private AnimalService animalService;

    public static void main(String[] args) {
        SpringApplication.run(ZooDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        animalService.createDb();

        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from animal");
        //JPAUtil.checkData("select * from animal_category");
        JPAUtil.checkData("select * from Supplier");
        JPAUtil.checkData("select * from fooditem");
        JPAUtil.checkData("select * from foods");


    }
}
