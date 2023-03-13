package com.example.productorderway2.dao;

import com.example.productorderway2.entiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
