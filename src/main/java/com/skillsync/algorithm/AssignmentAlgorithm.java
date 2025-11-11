package com.skillsync.algorithm;

import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import com.skillsync.model.Assignment;

import java.util.List;

public interface AssignmentAlgorithm {
    Assignment assignTask(Task task, List<Employee> employees);
}

