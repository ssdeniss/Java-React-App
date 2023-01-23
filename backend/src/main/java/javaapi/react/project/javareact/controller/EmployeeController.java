package javaapi.react.project.javareact.controller;

import javaapi.react.project.javareact.converter.*;
import javaapi.react.project.javareact.dto.*;
import javaapi.react.project.javareact.model.*;
import javaapi.react.project.javareact.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final EmployeeConverter employeeConverter;

    // Build create employee REST API
    // POST
    // http://localhost:8080/api/employees
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest employee) {
        return new ResponseEntity<Employee>(employeeService.
                saveEmployee(employeeConverter.
                        toEmploy(employee)), HttpStatus.CREATED);
    }

    // Build get all employee REST API
    // GET
    // http://localhost:8080/api/employees
    @GetMapping()
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService
                .getAllEmployees()
                .stream()
                .map(employeeConverter::toResponse)
                .toList();
//        List<EmployeeResponse> responseList = new ArrayList<>();
//        employeeList.forEach(el -> responseList.add(employeeConverter.toResponse(el)));
//        return responseList;

    }

    // Build get employee by ID REST API
    // GET
    // http://localhost:8080/api/employees/id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeByID(@PathVariable("id") long employeeId) {
        return ResponseEntity.ok(employeeConverter
                .toResponse(employeeService
                        .getEmployeeById(employeeId)));
    }

    // Build update employee REST API
    // PUT
    // http://localhost:8080/api/employees/id
    @PutMapping("{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeRequest payload) {
        Employee employee = employeeConverter.toEmploy(payload);
        return ResponseEntity
                .ok(employeeConverter
                        .toResponse(employeeService
                                .updateEmployee(id, employee)));
    }
    // Build delete employee REST API
    // DELETE
    // http://localhost:8080/api/employees/id

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        // delete employee from database
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);

    }
}
