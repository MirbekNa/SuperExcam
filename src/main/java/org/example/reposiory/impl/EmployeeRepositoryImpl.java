package org.example.reposiory.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.config.Configuration;
import org.example.entity.DepartMent;
import org.example.entity.Employee;
import org.example.reposiory.EmployRepository;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployRepository {
    private static EntityManagerFactory entityManagerFactory = Configuration.getSessionFactory();

    @Override
    public String createEmployee(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return "Employee saved";
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String getAllEmployee() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            entityManager.getTransaction().commit();
            return employeeList.toString() + " Got";
        } finally {
            entityManager.close();
        }
    }


    public static String asign(Long employeeId, Long departmentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee employeeToUpdate = entityManager.find(Employee.class, employeeId);
            if (employeeToUpdate != null) {
                DepartMent department = entityManager.find(DepartMent.class, departmentId);
                if (department != null) {
                    employeeToUpdate.setDepartment(department);
                    entityManager.merge(employeeToUpdate);
                    entityManager.getTransaction().commit();

                    return "Employee with ID " + employeeId + " updated with Department ID " + departmentId;
                } else {
                    return "Department with ID " + departmentId + " not found";
                }
            } else {
                return "Employee with ID " + employeeId + " not found";
            }
        } finally {
            entityManager.close();
        }
    }


    @Override
    public String updateEmployee(Long id, Employee updatedEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, id);
            if (employee != null) {
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setAge(updatedEmployee.getAge());
                employee.setSalary(updatedEmployee.getSalary());
                entityManager.getTransaction().commit();
                return "Employee with ID " + id + " updated";
            } else {
                return "Employee with ID " + id + " not found";
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalary() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.salary", Employee.class)
                    .getResultList();
            entityManager.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Error getting employees: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Employee> getAllEmployeesSortedBySalaryDesc() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.salary desc", Employee.class)
                    .getResultList();
            entityManager.getTransaction().commit();
            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Error getting employees: " + e.getMessage(), e);
        }
    }
    @Override
    public String deleteEmployee(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Employee employeeToDelete = entityManager.find(Employee.class, id);
            if (employeeToDelete != null) {
                entityManager.remove(employeeToDelete);
                entityManager.getTransaction().commit();
                return "Employee with ID " + id + " deleted";
            } else {
                return "Employee with ID " + id + " not found";
            }
        } finally {
            entityManager.close();
        }
    }
}
