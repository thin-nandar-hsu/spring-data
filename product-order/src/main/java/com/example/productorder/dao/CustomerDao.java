package com.example.productorder.dao;

import com.example.productorder.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerOrder, Integer>{
}
