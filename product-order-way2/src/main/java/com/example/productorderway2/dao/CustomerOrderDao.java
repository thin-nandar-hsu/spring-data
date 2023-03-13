package com.example.productorderway2.dao;

import com.example.productorderway2.entiy.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder,Integer> {
}
