package com.example.conventionrepository.dao;

import com.example.conventionrepository.custom.CustomEmployeeDao;
import com.example.conventionrepository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeDao extends CrudRepository<Employee,Integer> , CustomEmployeeDao {

      Optional<Employee> findEmployeeByEmail(String email);

    Optional<Employee> findTopByOrderBySalaryDesc();


//      @Query
//              ("select e from Employee e where e.salary = (select max (a.salary) from Employee a) ")
//      Optional<Employee> findLargestSalary();

      Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName,String lastName);
}
