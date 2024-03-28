package com.java.employeeservice.controller;


import com.java.employeeservice.model.Employee;
import com.java.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.addEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    Employee findById(@PathVariable Long Id) {
        return employeeRepository.getEmployeeById(Id);
    }

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    List<Employee> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        return employeeRepository.getEmployeesByDepartmentId(departmentId);
    }

}
