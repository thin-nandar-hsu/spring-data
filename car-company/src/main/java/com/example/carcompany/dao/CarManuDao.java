package com.example.carcompany.dao;

import com.example.carcompany.entity.CarManufacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarManuDao extends JpaRepository<CarManufacture,Integer> {

}
