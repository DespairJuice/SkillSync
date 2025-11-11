package com.skillsync.service.impl;

import com.skillsync.model.Employee;
import com.skillsync.repository.EmployeeRepository;
import com.skillsync.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAvailableEmployees(double minDisponibilidad) {
        return employeeRepository.findByDisponibilidadGreaterThan(minDisponibilidad);
    }
}