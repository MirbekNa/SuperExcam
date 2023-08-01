package org.example.service;

import org.example.entity.DepartMent;

import java.util.List;

public interface DepartmentService {
    String createDepartMent(DepartMent departMent);
    String getAllDepartment();

    DepartMent findDepartmentWithMaxEmployNumber();
    String updateDepartment(Long id,DepartMent updatedDepartment);
    String deleteDepartment(Long id);
}
