package com.example.productorder.dao;

import com.example.productorder.entity.CustomerOrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusOrderProductDao extends JpaRepository<CustomerOrderHasProduct,Integer> {
}
