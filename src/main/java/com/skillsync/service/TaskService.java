package com.skillsync.service;

import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
    List<Task> findByPriority(TaskPriority priority);
}