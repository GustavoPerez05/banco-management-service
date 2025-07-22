package br.com.banco.managementservice.adapters.in.rest;

import br.com.banco.managementservice.application.service.EmployeeService;
import br.com.banco.managementservice.domain.model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.banco.managementservice.application.dto.CreateEmployeeRequest;
import br.com.banco.managementservice.application.dto.UpdateEmployeeRequest;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody CreateEmployeeRequest request) {
        Employee employee = new Employee(
            request.getName(),
            request.getEmail(),
            request.getDepartment()
        );
        Employee saved = service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody UpdateEmployeeRequest request) {
        Employee updated = new Employee(
            request.getName(),
            request.getEmail(),
            request.getDepartment()
        );
        
    return ResponseEntity.ok(service.update(id, updated));
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
