package br.com.banco.managementservice.application.service;

import br.com.banco.managementservice.domain.model.Employee;
import br.com.banco.managementservice.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
