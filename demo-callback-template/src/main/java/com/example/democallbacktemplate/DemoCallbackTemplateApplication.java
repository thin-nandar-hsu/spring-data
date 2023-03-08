package com.example.democallbacktemplate;

import com.example.democallbacktemplate.ds.Employee;
import com.example.democallbacktemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoCallbackTemplateApplication implements CommandLineRunner {


    @Autowired
    private EmployeeService employeeService;
    public static void main(String[] args) {
        SpringApplication.run(DemoCallbackTemplateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        employeeService.listForEmployee().forEach(System.out::println);

        //RowCallBackHandler
        System.out.println("Average Salary::" + employeeService.avgRollCallBackHandler());

        //ResultSetExtractor
        System.out.println("Average Salary::" + employeeService.avgResultSetExtractor());

        // Update
        System.out.println();
        employeeService.creatEmployee(new Employee
                (6,"Thu","Zar","thuz@gmail.com",5000));
        employeeService.listForEmployee().forEach(System.out::println);

        // *
        System.out.println("Average Salary of Native Way:" + employeeService.avgNativeWay());

        // *
        System.out.println("Average Salary of Modern Way:" + employeeService.avgModernWay());
        }
    }


