package org.example;

import org.example.config.Configuration;
import org.example.entity.DepartMent;
import org.example.entity.Employee;
import org.example.reposiory.impl.EmployeeRepositoryImpl;
import org.example.service.DepartmentService;
import org.example.service.EmployeeService;
import org.example.service.impl.DepartmentServiceImpl;
import org.example.service.impl.EmployeeServiceImpl;

public class App {
    public static void main(String[] args) {

        Employee employee = new Employee("gaga", " last name", 24, 66);
        DepartmentService service = new DepartmentServiceImpl();
        EmployeeService service1 = new EmployeeServiceImpl();
        DepartMent departMent = new DepartMent("Depar", 434);


    }
}
