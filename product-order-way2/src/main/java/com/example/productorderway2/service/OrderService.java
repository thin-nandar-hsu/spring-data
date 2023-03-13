package com.example.productorderway2.service;

import com.example.productorderway2.dao.CustomerOrderDao;
import com.example.productorderway2.entiy.*;
import com.example.productorderway2.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private final ProductDao productDao;



   @Autowired
    private final CustomerOrderDao customerOrderDao;

    public OrderService(ProductDao productDao, CustomerOrderDao customerOrderDao) {
        this.productDao = productDao;


        this.customerOrderDao = customerOrderDao;
    }

    @Transactional
    public void createDb(){

        Category c1 = new Category("Local");
        Category c2 = new Category("Global");


        Product p1 = new Product("Cosmetics",15000,"Beauty");
        Product p2 = new Product("Phone",850000,"Social");
        Product p3 = new Product("PC",1000000,"Gaming");

        CustomerOrder cus1 = new CustomerOrder();
        cus1.setAmount(15000);
        cus1.setConfirmNum(001);
        cus1.setTime(LocalDateTime.now());
        CustomerOrder cus2 = new CustomerOrder();
        cus2.setAmount(850000);
        cus2.setConfirmNum(002);
        cus2.setTime(LocalDateTime.now());

        CustomerOrder cus4 = new CustomerOrder();
        cus4.setAmount(850000);
        cus4.setConfirmNum(004);
        cus4.setTime(LocalDateTime.now());

        CustomerOrder cus3 = new CustomerOrder();
        cus3.setAmount(1000000);
        cus3.setConfirmNum(003);
        cus3.setTime(LocalDateTime.now());

        Customer customer1 = new Customer("Re Dono","re@gmail.com","0978654321","TGG","Yangon");
        Customer customer2 = new Customer("Mu Shi","mu@gmail.com","09786543567","STG","Yangon");
        Customer customer3 = new Customer("Yo Yo","yo@gmail.com","09786543987","KM","Shan");

         c1.addProducts(p1);
         c2.addProducts(p2);
         c2.addProducts(p3);

         customer1.addOrder(cus1);
         customer1.addOrder(cus2);
         customer2.addOrder(cus3);
         customer3.addOrder(cus4);

         p1.addCusOrder(cus1);
         p2.addCusOrder(cus2);
         p2.addCusOrder(cus4);
         p3.addCusOrder(cus3);

//         cus1.addProduct(p1);
//         cus2.addProduct(p2);
//         cus3.addProduct(p3);

         productDao.save(p1);
         productDao.save(p2);
         productDao.save(p3);

         customerOrderDao.save(cus1);
         customerOrderDao.save(cus3);
         customerOrderDao.save(cus2);
         customerOrderDao.save(cus4);


    }
}
