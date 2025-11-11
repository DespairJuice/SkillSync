package com.skillsync.controller;

import com.skillsync.model.Employee;
import com.skillsync.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
