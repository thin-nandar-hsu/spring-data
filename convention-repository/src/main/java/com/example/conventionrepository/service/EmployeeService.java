package com.example.conventionrepository.service;

import com.example.conventionrepository.dao.EmployeeDao;
import com.example.conventionrepository.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Iterable<Employee> listEmployee(){
        return employeeDao.findAll();
    }

    public Employee creatDb(Employee employee){
        return employeeDao.save(employee);

    }

    public Employee findLargestSalary(){
        return employeeDao.findTopByOrderBySalaryDesc()
                .orElseThrow(EntityNotFoundException::new);

    }

    public Employee findByEmail(String email){
        return employeeDao.findEmployeeByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Employee findFirstNameAndLastName(String firstName, String lastName){
        return employeeDao.findEmployeeByFirstNameLastName(firstName, lastName)    // method form CustomEmployeeDaoImpl
                .orElseThrow(EntityNotFoundException::new);
    }


}
