package com.example.conventionrepository.custom;

import com.example.conventionrepository.entity.Employee;

import java.util.Optional;

public interface CustomEmployeeDao {

    Optional<Employee> findEmployeeByFirstNameLastName(String firstName,String lastName);
}
