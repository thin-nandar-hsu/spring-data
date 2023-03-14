package com.example.springjpaelementcollectiontables.service;

import com.example.springjpaelementcollectiontables.dao.CustomerDao;
import com.example.springjpaelementcollectiontables.entity.Customer;
import com.example.springjpaelementcollectiontables.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    public void createDb(){
        Customer customer1 = new Customer("Re Dono","444444");
        Customer customer2 = new Customer("Mu Shi","666666");
        Customer customer3 = new Customer("Yo Yo","111111");

        customer3.addAddress("Kyouk Me");
        customer3.addAddress("Myawadi");
        customer3.addAddress("Yangon");
        customer3.addEmail("yoyo@gmail.com");
        customer3.addEmail("jj@gmail.com");

        customer1.addAddress("Yangon");
        customer1.addAddress("Shan");
        customer1.addPhone(new Phone("55-555-55","Telenor","iPhone"));
        customer1.addPhone(new Phone("44-444-44","Orredoo","iPhone"));
        customer1.addEmail("re@gmail.com");
        customer1.addEmail("dono@gamil.com");

        customer2.addAddress("Singapore");
        customer2.addAddress("KaLaw");
        customer2.addPhone(new Phone("99-999-99","Telenor","Samsung"));
        customer2.addPhone(new Phone("88-888-88","MPT","Sony"));
        customer2.addEmail("mu@gmail.com");
        customer2.addEmail("mushi@gmail.com");


        customerDao.save(customer1);
        customerDao.save(customer2);
        customerDao.save(customer3);


    }
}
