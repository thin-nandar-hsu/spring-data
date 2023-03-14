package com.example.carcompany.dao;

import com.example.carcompany.entity.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuDao extends JpaRepository<InsuranceCompany,Integer> {
}
