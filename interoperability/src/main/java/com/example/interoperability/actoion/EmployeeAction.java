package com.example.interoperability.actoion;

import com.example.interoperability.ds.Employee;
import com.example.interoperability.servic.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeAction {

    @Autowired
    private EmployeeService employeeService;


    public void deleteEmployee(){
        employeeService.deleteAll();
    }

    public Iterable<Employee> findAll(){
        return employeeService.listEmployee();
    }

    @Transactional
    public void createEmployee(){

        employeeService.createEmployeeWithJdbc(1,"Re","Dono","re@gmail.com",10000);
        employeeService.createEmployeeWithJdbc(2,"Mu","Shi","mu@gamil.com",15000);

        employeeService.createEmployeeWithJpa(new Employee(3,"La","La","la@gmail.com",8000.0));

        throw new RuntimeException();
    }

}
