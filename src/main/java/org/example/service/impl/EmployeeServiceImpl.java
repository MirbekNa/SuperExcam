package org.example.service.impl;

import org.example.entity.Employee;
import org.example.reposiory.EmployRepository;
import org.example.reposiory.impl.EmployeeRepositoryImpl;
import org.example.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
EmployRepository repository = new EmployeeRepositoryImpl();
    @Override
    public String createEmployee(Employee employee) {
        return repository.createEmployee(employee);
    }

    @Override
    public String getAllEmployee() {

        return repository.getAllEmployee();
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalary() {
        return repository.getAllEmployeesSortedBySalary();
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalaryDesc() {
        return repository.getAllEmployeesSortedBySalaryDesc();
    }

    @Override
    public String updateEmployee(Long id,Employee updatedEmployee) {
        return repository.updateEmployee(id,updatedEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        return repository.deleteEmployee(id);
    }
}
