package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.DepartMent;
import org.example.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Configuration {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(DepartMent.class);
        configuration.addAnnotatedClass(Employee.class);
        return configuration.buildSessionFactory();
    }
    public static EntityManager createEntityManager() {
        return getSessionFactory().createEntityManager();
    }
}
