package javaapi.react.project.javareact.service;

import javaapi.react.project.javareact.exception.*;
import javaapi.react.project.javareact.model.*;
import javaapi.react.project.javareact.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;

    // POST

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // GET ALL

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET BY ID

    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    // UPDATE BY ID

    public Employee updateEmployee(long id, Employee employee) {
        // check if id exist
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save employee to database

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    // DELETE BY ID

    public void deleteEmployee(long id) {
        // check if id exist
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employ", "id", id));
        employeeRepository.deleteById(id);
    }
}
