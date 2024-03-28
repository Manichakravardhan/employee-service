package com.java.employeeservice.repository;


import com.java.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public Employee getEmployeeById(Long Id) {
        return employeeList.stream().filter(employee -> employee.id().equals(Id)).findFirst().orElseThrow();
    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeList.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }
}
