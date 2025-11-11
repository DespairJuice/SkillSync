package com.skillsync.algorithm;

import com.skillsync.model.Employee;
import com.skillsync.model.Task;

public interface ScoringStrategy {
    double calculateScore(Employee employee, Task task);
}
