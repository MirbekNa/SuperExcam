package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee);

    String getAllEmployee();
    List<Employee> getAllEmployeesSortedBySalary();
    List<Employee> getAllEmployeesSortedBySalaryDesc();

    String updateEmployee(Long id,Employee updatedEmployee);

    String deleteEmployee(Long id);
}
