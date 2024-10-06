package com.example.EmployeStore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeStore.EmployeENtity;
import com.example.EmployeStore.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000") // Allow only this origin for this controller

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees (already created before)
    @GetMapping
    public List<EmployeENtity> getEmployees() {
        return employeeService.getAllEmployees();
    }

    // Add a new employee
    @PostMapping
    public EmployeENtity addEmployee(@RequestBody EmployeENtity employee) {
        return employeeService.addEmployee(employee);
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public Optional<EmployeENtity> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update an employee
    @PutMapping("/{id}")
    public EmployeENtity updateEmployee(@PathVariable Long id, @RequestBody EmployeENtity updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Employee deleted successfully!";
        } else {
            return "Employee not found.";
        }
    }
}
