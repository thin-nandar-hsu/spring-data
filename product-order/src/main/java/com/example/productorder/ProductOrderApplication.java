package com.example.productorder;


import com.example.productorder.service.OrderService;
import com.example.productorder.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ProductOrderApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(ProductOrderApplication.class, args);


        }

    @Override
    public void run(String... args) throws Exception {
        orderService.createDb();

        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from cus_product_order");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from customer");

    }
}







