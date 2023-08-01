package org.example.service.impl;

import org.example.entity.DepartMent;
import org.example.reposiory.DepartMentRepository;
import org.example.reposiory.impl.DepartmentRepositoryImpl;
import org.example.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
  DepartMentRepository repository = new DepartmentRepositoryImpl();
    @Override
    public String createDepartMent(DepartMent departMent) {
        return repository.createDepartMent(departMent);
    }

    @Override
    public String getAllDepartment() {
        return repository.getAllDepartment();
    }

    @Override
    public DepartMent findDepartmentWithMaxEmployNumber() {
        return repository.findDepartmentWithMaxEmployNumber();
    }

    @Override
    public String updateDepartment(Long id,DepartMent updatedDepartment) {
        return repository.updateDepartment(id,updatedDepartment);
    }

    @Override
    public String deleteDepartment(Long id) {
        return repository.deleteDepartment(id);
    }
}
