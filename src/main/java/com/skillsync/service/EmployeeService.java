package com.skillsync.service;

import com.skillsync.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee> findAvailableEmployees(double minDisponibilidad);
}