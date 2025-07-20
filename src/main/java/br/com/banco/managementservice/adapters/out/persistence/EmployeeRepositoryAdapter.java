package br.com.banco.managementservice.adapters.out.persistence;

import br.com.banco.managementservice.domain.model.Employee;
import br.com.banco.managementservice.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryAdapter implements EmployeeRepository {

    private final SpringDataEmployeeRepository springDataRepository;

    public EmployeeRepositoryAdapter(SpringDataEmployeeRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return springDataRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }
}
