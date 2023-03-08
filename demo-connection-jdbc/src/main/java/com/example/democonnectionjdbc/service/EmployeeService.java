package com.example.democonnectionjdbc.service;

import com.example.democonnectionjdbc.dao.EmployeeDao;
import com.example.democonnectionjdbc.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void creatEmployeeWithTransaction(){
        employeeDao.creatEmployee(new Employee(7,"Nu","Gao","nu@gmail.com",4000));
        employeeDao.creatEmployee(new Employee(8,"Nu","Nu","nunu@gmail.com",6000));
        employeeDao.creatEmployee(new Employee(9,"Shu","Gao","shu@gmail.com",4000));
        employeeDao.creatEmployee(new Employee(10,"Lao","Yi","lao@gmail.com",4000));
    }
}
