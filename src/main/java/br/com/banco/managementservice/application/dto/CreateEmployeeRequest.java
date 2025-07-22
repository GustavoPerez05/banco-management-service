package br.com.banco.managementservice.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateEmployeeRequest {

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail não pode estar em branco")
    private String email;

    @NotBlank(message = "Departamento não pode estar em branco")
    private String department;

    // Getters e Setters
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
}
