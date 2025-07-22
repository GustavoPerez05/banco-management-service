package br.com.banco.managementservice.adapters.in.rest;

import br.com.banco.managementservice.application.dto.CreateEmployeeRequest;
import br.com.banco.managementservice.application.dto.UpdateEmployeeRequest;
import br.com.banco.managementservice.application.service.EmployeeService;
import br.com.banco.managementservice.domain.exception.BadRequestException;
import br.com.banco.managementservice.domain.exception.ResourceNotFoundException;
import br.com.banco.managementservice.domain.model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateEmployeeRequest request) {
        try {
            Employee employee = new Employee(
                request.getName(),
                request.getEmail(),
                request.getDepartment()
            );
            Employee saved = service.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + id + " not found"));
            return ResponseEntity.ok(employee);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody UpdateEmployeeRequest request) {
        try {
            Employee updated = new Employee(
                request.getName(),
                request.getEmail(),
                request.getDepartment()
            );
            Employee updatedEmployee = service.update(id, updated);
            return ResponseEntity.ok(updatedEmployee);
        } catch (ResourceNotFoundException | BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
