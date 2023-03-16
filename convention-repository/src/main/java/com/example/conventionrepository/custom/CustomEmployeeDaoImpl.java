package com.example.conventionrepository.custom;

import com.example.conventionrepository.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomEmployeeDaoImpl implements CustomEmployeeDao{

    @Autowired
    private EntityManager em;
    @Override
    public Optional<Employee> findEmployeeByFirstNameLastName(String firstName, String lastName) {
        return Optional.of(em.createQuery("select e from Employee e where e.firstName=:firstName and e.lastName=:lastName",Employee.class)
                .setParameter("firstName",firstName)
                .setParameter("lastName",lastName)
                .getSingleResult());
    }
}
