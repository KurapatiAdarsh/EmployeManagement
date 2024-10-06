package com.example.EmployeStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeStore.EmployeENtity;

public interface EmployeeRepository extends JpaRepository<EmployeENtity, Long> {
}
