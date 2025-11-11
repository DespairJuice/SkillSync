package com.skillsync.service.impl;

import com.skillsync.model.Assignment;
import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;
import com.skillsync.repository.AssignmentRepository;
import com.skillsync.repository.TaskRepository;
import com.skillsync.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
        // Delete associated assignments first
        List<Assignment> assignments = assignmentRepository.findByTask(task);
        for (Assignment assignment : assignments) {
            assignmentRepository.delete(assignment);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findByPriority(TaskPriority priority) {
        return taskRepository.findByPriority(priority);
    }
}