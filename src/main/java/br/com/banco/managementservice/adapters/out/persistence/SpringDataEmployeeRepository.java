package br.com.banco.managementservice.adapters.out.persistence;

import br.com.banco.managementservice.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeeRepository extends JpaRepository<Employee, Long> {
}
