package com.example.EmployeStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeStore.EmployeENtity;
import com.example.EmployeStore.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeENtity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Save new employee
    public EmployeENtity addEmployee(EmployeENtity employee) {
        return employeeRepository.save(employee);
    }

    // Method to get an employee by ID
    public Optional<EmployeENtity> getEmployeeById(Long id) {
        return employeeRepository.findById(id); // Fetches employee by ID
    }

    // Method to update an employee
    public EmployeENtity updateEmployee(Long id, EmployeENtity updatedEmployee) {
        // Check if employee exists
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id); // Set the ID for the updated entity
            return employeeRepository.save(updatedEmployee); // Save updated entity
        } else {
            return null; // Or throw an exception
        }
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true; // Employee deleted successfully
        } else {
            return false; // Employee not found
        }
    }

}
