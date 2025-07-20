// Criação de Testes Unitários para a função "Employee Service"
// Segmento de Testes (JUnit 5 + Mockito):
// 1. Salvar Funcionário
// 2. Listar Todos os Funcionários
// 3. Remover Funcionário

package br.com.banco.managementservice.application.service;

import br.com.banco.managementservice.domain.model.Employee;
import br.com.banco.managementservice.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    void testSaveEmployee() {
        Employee employee = new Employee("Gustavo", "gustavo@banco.com.br", "TI");
        when(repository.save(employee)).thenReturn(employee);

        Employee saved = service.save(employee);

        assertNotNull(saved);
        assertEquals("Gustavo", saved.getName());
        verify(repository, times(1)).save(employee);
    }

    @Test
    void testFindAllEmployees() {
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
    void testDeleteEmployee() {
        Long id = 1L;

        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }
}

