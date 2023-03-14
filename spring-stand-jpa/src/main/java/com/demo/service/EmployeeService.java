package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeDao employeeDao;

    public List<Employee> listEmployee(){
        return employeeDao.findAll();
    }


    @Transactional
    public void createDb(){
        Employee e1 = new Employee(1,"Re","Dono","re@gmail.com",800000);
        Employee e2 = new Employee(2,"Mu","Shi","mu@gmail.com",1000000);
        Employee e3 = new Employee(3,"Yo","Yo","yo@gmail.com",700000);

        employeeDao.save(e1);
        employeeDao.save(e2);
        employeeDao.save(e3);

    }
}
