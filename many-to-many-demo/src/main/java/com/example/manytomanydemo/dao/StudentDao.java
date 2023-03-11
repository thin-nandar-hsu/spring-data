package com.example.manytomanydemo.dao;

import com.example.manytomanydemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
