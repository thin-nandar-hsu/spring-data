package com.example.productorder.service;

import com.example.productorder.dao.CusOrderProductDao;
import com.example.productorder.dao.CustomerDao;
import com.example.productorder.dao.ProductDao;
import com.example.productorder.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private final ProductDao productDao;

    @Autowired
    private final CusOrderProductDao cusOrderProductDao;

    @Autowired
    private final CustomerDao customerDao;

    public OrderService(ProductDao productDao, CusOrderProductDao cusOrderProductDao,  CustomerDao customerDao) {
        this.productDao = productDao;
        this.cusOrderProductDao = cusOrderProductDao;
        this.customerDao = customerDao;

    }

    @Transactional
    public void createDb(){
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
        CustomerOrder cus3 = new CustomerOrder();
        cus3.setAmount(1000000);
        cus3.setConfirmNum(003);
        cus3.setTime(LocalDateTime.now());

        CustomerOrderHasProduct cusO1 = new CustomerOrderHasProduct(1);
        CustomerOrderHasProduct cusO2 = new CustomerOrderHasProduct(2);
        CustomerOrderHasProduct cusO3 = new CustomerOrderHasProduct(3);


        Category c1 = new Category("Local");
        Category c2 = new Category("Global");

        Customer customer1 = new Customer("Re Dono","re@gmail.com","0978654321","TGG","Yangon");
        Customer customer2 = new Customer("Mu Shi","mu@gmail.com","09786543567","STG","Yangon");
        Customer customer3 = new Customer("Yo Yo","yo@gmail.com","09786543987","KM","Shan");



        c1.addProduct(p1);
        c2.addProduct(p2);
        c2.addProduct(p3);


        customer1.addOrder(cus1);
        customer1.addOrder(cus2);
        customer2.addOrder(cus3);
        customer3.addOrder(cus2);

        p1.addId(cusO1);
        p2.addId(cusO2);
        p3.addId(cusO3);


        cus1.addId(cusO1);
        cus2.addId(cusO2);
        cus3.addId(cusO3);


        productDao.save(p1);
        productDao.save(p2);
        productDao.save(p3);

        customerDao.save(cus1);
        customerDao.save(cus2);
        customerDao.save(cus3);

        cusOrderProductDao.save(cusO1);
       cusOrderProductDao.save(cusO2);
       cusOrderProductDao.save(cusO3);

    }
}
