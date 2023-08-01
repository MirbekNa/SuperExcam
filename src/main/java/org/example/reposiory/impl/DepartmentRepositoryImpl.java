package org.example.reposiory.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.config.Configuration;
import org.example.entity.DepartMent;
import org.example.entity.Employee;
import org.example.reposiory.DepartMentRepository;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartMentRepository {
    private EntityManagerFactory entityManagerFactory = Configuration.getSessionFactory();

    @Override
    public String createDepartMent(DepartMent departMent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(departMent);
            entityManager.getTransaction().commit();
            return "Department saved";
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String getAllDepartment() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<DepartMent> departMents = entityManager.createQuery("SELECT e FROM DepartMent e", DepartMent.class).getResultList();
            entityManager.getTransaction().commit();
            return departMents.toString() + " Got";
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String updateDepartment(Long id, DepartMent updatedDepartment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            DepartMent existingDepartment = entityManager.find(DepartMent.class, id);
            if (existingDepartment != null) {
                existingDepartment.setName(updatedDepartment.getName());
                existingDepartment.setMaxEmployNumber(updatedDepartment.getMaxEmployNumber());
                entityManager.getTransaction().commit();
                return "Department with ID " + id + " updated";
            } else {
                return "Department with ID " + id + " not found";
            }
        } finally {
            entityManager.close();
        }
    }
    public DepartMent findDepartmentWithMaxEmployNumber() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String queryStr = "SELECT d FROM DepartMent d ORDER BY d.maxEmployNumber DESC";
            TypedQuery<DepartMent> query = entityManager.createQuery(queryStr, DepartMent.class);
            query.setMaxResults(1); // Вернуть только первый результат
            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteDepartment(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            DepartMent departmentToDelete = entityManager.find(DepartMent.class, id);
            if (departmentToDelete != null) {
                entityManager.remove(departmentToDelete);
                entityManager.getTransaction().commit();

                return "Department with ID " + id + " deleted";
            } else {
                return "Department with ID " + id + " not found";
            }
        } finally {
            entityManager.close();
        }
    }

}

