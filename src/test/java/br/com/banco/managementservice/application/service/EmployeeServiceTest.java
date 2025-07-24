// Criação de Testes Unitários para a função "Employee Service"
// Segmento de Testes (JUnit 5 + Mockito):
// 1. Salvar Funcionário
// 2. Listar Todos os Funcionários
// 3. Update de Informações dos Funcrionários
// 4. Remover Funcionário

package br.com.banco.managementservice.application.service;

import br.com.banco.managementservice.domain.model.Employee;
import br.com.banco.managementservice.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private EmployeeRepository repository;
    private EmployeeService service;

    @BeforeEach
    void setup() {
        repository = mock(EmployeeRepository.class);
        service = new EmployeeService(repository);
    }

    @Test
    void shouldSaveEmployeeSuccessfully() {
        Employee employee = new Employee("Gustavo", "gustavo@banco.com.br", "TI");
        when(repository.save(employee)).thenReturn(employee);

        Employee saved = service.save(employee);

        assertNotNull(saved);
        assertEquals("Gustavo", saved.getName());
        verify(repository, times(1)).save(employee);
    }

    @Test
    void shouldListAllEmployees() {
        List<Employee> list = Arrays.asList(
                new Employee("Gustavo", "gustavo@banco.com.br", "TI"),
                new Employee("Renato", "renato@banco.com.br", "Financeiro")
        );
        when(repository.findAll()).thenReturn(list);

        List<Employee> result = service.findAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldDeleteEmployeeById() {
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(true);

        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void shouldUpdateEmployeeIfExists() {
        Long id = 1L;
        Employee existing = new Employee("João", "joao@banco.com", "TI");
        Employee updated = new Employee("João Silva", "joao@banco.com", "RH");

        when(repository.findById(id)).thenReturn(java.util.Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

    Employee result = service.update(id, updated);

        assertEquals("João Silva", result.getName());
        assertEquals("RH", result.getDepartment());
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(existing);
    }
    @Test
    void shouldThrowWhenUpdatingNonExistentEmployee() {
        Long id = 99L;
        Employee updated = new Employee("Carlos", "carlos@banco.com", "TI");

        when(repository.findById(id)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> service.update(id, updated));
        verify(repository, times(1)).findById(id);
    }
}
