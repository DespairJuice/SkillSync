package com.skillsync.service.impl;

import com.skillsync.algorithm.AssignmentEngine;
import com.skillsync.model.Assignment;
import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import com.skillsync.repository.AssignmentRepository;
import com.skillsync.repository.EmployeeRepository;
import com.skillsync.repository.TaskRepository;
import com.skillsync.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentEngine assignmentEngine;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment generateAssignment(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + taskId));

        List<Employee> availableEmployees = employeeRepository.findByDisponibilidadGreaterThan(0.3);

        // Obtener asignaciones activas para calcular carga de trabajo actual
        List<Assignment> activeAssignments = assignmentRepository.findByEstadoNot("completed");

        // Ajustar disponibilidad efectiva basada en carga de trabajo actual
        for (Employee employee : availableEmployees) {
            double currentWorkloadHours = activeAssignments.stream()
                    .filter(a -> a.getEmployee().getId().equals(employee.getId()))
                    .mapToDouble(a -> a.getTask().getEstimatedHours())
                    .sum();
            double workloadDeduction = currentWorkloadHours / 40.0; // Asumiendo 40 horas/semana
            employee.setDisponibilidad(Math.max(0.0, employee.getDisponibilidad() - workloadDeduction));
        }

        // Filtrar empleados que aún tengan disponibilidad efectiva > 0.3 después del ajuste
        availableEmployees = availableEmployees.stream()
                .filter(e -> e.getDisponibilidad() > 0.3)
                .toList();

        if (availableEmployees.isEmpty()) {
            throw new RuntimeException("No hay empleados disponibles para asignar la tarea");
        }

        Assignment assignment = assignmentEngine.generateAssignment(task, availableEmployees);

        // Actualizar disponibilidad del empleado asignado
        Employee assignedEmployee = assignment.getEmployee();
        double hoursToDeduct = task.getEstimatedHours() / 40.0; // Asumiendo 40 horas/semana
        assignedEmployee.setDisponibilidad(Math.max(0.0, assignedEmployee.getDisponibilidad() - hoursToDeduct));
        employeeRepository.save(assignedEmployee);

        return assignmentRepository.save(assignment);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        Assignment existing = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));
        existing.setEstado(assignment.getEstado());
        if ("completed".equals(assignment.getEstado())) {
            Task task = existing.getTask();
            task.setStatus("completed");
            taskRepository.save(task);
        }
        return assignmentRepository.save(existing);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}