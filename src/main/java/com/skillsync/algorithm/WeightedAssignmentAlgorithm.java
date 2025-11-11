package com.skillsync.algorithm;

import com.skillsync.model.Assignment;
import com.skillsync.model.Employee;
import com.skillsync.model.Task;

import java.util.Comparator;
import java.util.List;

public class WeightedAssignmentAlgorithm implements AssignmentAlgorithm {

    private final ScoringStrategy scoringStrategy;

    public WeightedAssignmentAlgorithm(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    @Override
    public Assignment assignTask(Task task, List<Employee> employees) {
        Employee bestMatch = employees.stream()
                .max(Comparator.comparingDouble(e -> scoringStrategy.calculateScore(e, task)))
                .orElseThrow(() -> new RuntimeException("No employees available for assignment"));

        return new Assignment(task, bestMatch);
    }
}

