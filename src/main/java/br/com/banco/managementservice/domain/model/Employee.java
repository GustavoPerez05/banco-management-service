package br.com.banco.managementservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail não pode estar em branco")
    private String email;

    @NotBlank(message = "Departamento não pode estar em branco")
    private String department;

    public Employee() {}

    public Employee(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters e setters

    public Long getId() {
        return id; 
    }

    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email; 
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department; 
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Equals e HashCode baseados no ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
