package com.example.springjpaelementcollectiontables;

import com.example.springjpaelementcollectiontables.service.CustomerService;
import com.example.springjpaelementcollectiontables.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaElementcollectiontablesApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaElementcollectiontablesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerService.createDb();
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_phone");
        JPAUtil.checkData("select * from customer_email");
        JPAUtil.checkData("select * from customer_addresses");

    }
}
