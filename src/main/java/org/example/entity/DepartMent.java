package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class DepartMent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_gen")
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", allocationSize = 1)
    private Long id;
    private String name;
   private int maxEmployNumber;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    public void addEmployee(Employee employee) {
        if (employees.size() < maxEmployNumber) {
            employees.add(employee);
            employee.setDepartment(this);
        } else {
            throw new RuntimeException("Department is already at maximum capacity.");
        }
    }
    @Override
    public String toString() {
        return "DepartMent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxEmployNumber=" + maxEmployNumber +
                '}';
    }

    public DepartMent(String name, int maxEmployNumber) {
        this.name = name;
        this.maxEmployNumber = maxEmployNumber;
    }
}
