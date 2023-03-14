package com.example.springjpaelementcollectiontables.dao;

import com.example.springjpaelementcollectiontables.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
