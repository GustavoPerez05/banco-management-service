package br.com.banco.managementservice.application.service;

import br.com.banco.managementservice.domain.model.Employee;
import br.com.banco.managementservice.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        return repository.findById(id)
            .map(existing -> {
                existing.setName(updatedEmployee.getName());
                existing.setEmail(updatedEmployee.getEmail());
                existing.setDepartment(updatedEmployee.getDepartment());
                return repository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado."));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
