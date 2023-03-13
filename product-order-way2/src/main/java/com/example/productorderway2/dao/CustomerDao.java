package com.example.productorderway2.dao;

import com.example.productorderway2.entiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
