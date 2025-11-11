package com.skillsync.controller;

import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;
import com.skillsync.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable TaskPriority priority) {
        return ResponseEntity.ok(taskService.findByPriority(priority));
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
