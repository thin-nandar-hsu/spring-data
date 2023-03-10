package com.example.onetoonedemo.servic;

import com.example.onetoonedemo.dao.AddressDao;
import com.example.onetoonedemo.dao.CustomerDao;
import com.example.onetoonedemo.entity.Address;
import com.example.onetoonedemo.entity.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerDao customerDao;     // Autowired


    private final AddressDao addressDao;        // Autowired

    public CustomerService(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    public Customer findCustomerById(Integer id){
        return customerDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void createDb(){
        Customer cus1= new Customer("Re","097866543","re@gmail.com");
        Customer cus2 = new Customer("Mu Shi","097543678","mu@gmail.com");

        Address add1 = new Address("SanPya","No.37","Yangon");
        Address add2 = new Address("DawNa","No.44","Yangon");


        //mapping

        cus1.setAddress(add1);
        cus2.setAddress(add2);
        add1.setCustomer(cus1);
        add2.setCustomer(cus2);



        customerDao.save(cus1);    //Manage State
        customerDao.save(cus2);    //Manage State
        //addressDao.save(add1);     //Manage State
        //addressDao.save(add2);     //Manage State


    }
}
