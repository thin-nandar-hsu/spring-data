package com.example.carcompany;

import com.example.carcompany.service.CarService;
import com.example.carcompany.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarCompanyApplication implements CommandLineRunner {

    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarCompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        carService.createDb();

        JPAUtil.checkData("select * from car");
        JPAUtil.checkData("select * from company");
        JPAUtil.checkData("select * from car_manufacture");
        JPAUtil.checkData("select * from insurance_company");
        JPAUtil.checkData("select * from person");
//        JPAUtil.checkData("select * from car_owner");
        JPAUtil.checkData("select * from car_driver");
        JPAUtil.checkData("select * from car_insurance");



    }
}
