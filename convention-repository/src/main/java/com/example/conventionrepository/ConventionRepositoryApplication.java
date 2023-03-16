package com.example.conventionrepository;

import com.example.conventionrepository.entity.Employee;
import com.example.conventionrepository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ConventionRepositoryApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(ConventionRepositoryApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Employee e1 = new Employee("Re","Dono","re@gmail.com",1000000);
        Employee e2 = new Employee("Mu","Shi","mu@gmail.com",800000);
        Employee e3 = new Employee("Yo","Lo","yolo@gmail.com",700000);
        Employee e4 = new Employee("Kon","Thar","kon@gmail.com",900000);

        employeeService.creatDb(e1);
        employeeService.creatDb(e2);
        employeeService.creatDb(e3);
        employeeService.creatDb(e4);

        employeeService.listEmployee().forEach(System.out::println);
        System.out.println("-------------");

        System.out.println("Find employee by name:");
        System.out.println(employeeService.findFirstNameAndLastName("Mu","Shi"));
        System.out.println("-------------------");

        System.out.println("Find employee by email:");
        System.out.println(employeeService.findByEmail("yolo@gmail.com"));
        System.out.println("--------------------");


        System.out.println("Find Largest Salary:");
        System.out.println(employeeService.findLargestSalary());



    }
}
