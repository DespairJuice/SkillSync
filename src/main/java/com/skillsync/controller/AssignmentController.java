package com.skillsync.controller;

import com.skillsync.dto.AssignmentDTO;
import com.skillsync.model.Assignment;
import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import com.skillsync.repository.EmployeeRepository;
import com.skillsync.repository.TaskRepository;
import com.skillsync.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Assignment> getAll() {
        return assignmentService.getAllAssignments();
    }

    @PostMapping
    public ResponseEntity<Assignment> create(@RequestBody AssignmentDTO dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + dto.getTaskId()));
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + dto.getEmployeeId()));
        Assignment assignment = new Assignment(task, employee);
        assignment.setEstado(dto.getEstado() != null ? dto.getEstado() : "ASIGNADA");
        if (dto.getFechaAsignacion() != null) {
            assignment.setFechaAsignacion(dto.getFechaAsignacion());
        }
        return ResponseEntity.ok(assignmentService.createAssignment(assignment));
    }

    @PostMapping("/generate/{taskId}")
    public ResponseEntity<Assignment> generate(@PathVariable Long taskId) {
        return ResponseEntity.ok(assignmentService.generateAssignment(taskId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        String estado = (String) updates.get("estado");
        Assignment existing = assignmentService.getAllAssignments().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));
        existing.setEstado(estado);
        if ("completed".equals(estado)) {
            Task task = existing.getTask();
            task.setStatus("completed");
            taskRepository.save(task);
        }
        return ResponseEntity.ok(assignmentService.updateAssignment(id, existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
