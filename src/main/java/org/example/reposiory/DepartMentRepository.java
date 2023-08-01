package org.example.reposiory;

import org.example.entity.DepartMent;

import java.util.List;

public interface DepartMentRepository {
String createDepartMent(DepartMent departMent);
String getAllDepartment();
    DepartMent findDepartmentWithMaxEmployNumber();
String updateDepartment(Long id,DepartMent updatedDepartment);
String deleteDepartment(Long id);
}
