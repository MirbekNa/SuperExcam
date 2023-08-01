package org.example.reposiory;
import org.example.entity.Employee;

import java.util.List;

public interface EmployRepository {
    String createEmployee(Employee employee);
    String getAllEmployee();
    List<Employee> getAllEmployeesSortedBySalary();
    List<Employee> getAllEmployeesSortedBySalaryDesc();
    String updateEmployee(Long id,Employee updatedEmployee);
    String deleteEmployee(Long id);
}
