package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Long> {
    // JpaRepository already provides methods for basic CRUD operations
}
