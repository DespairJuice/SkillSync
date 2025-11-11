package com.skillsync.algorithm;

import com.skillsync.model.Assignment;
import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AssignmentEngine {

    private final AssignmentAlgorithm algorithm;

    public AssignmentEngine(DefaultScoringStrategy scoringStrategy) {
        // Puedes cambiar por otro algoritmo en el futuro (IA, ML, heurístico, etc.)
        this.algorithm = new WeightedAssignmentAlgorithm(scoringStrategy);
    }

    public Assignment generateAssignment(Task task, List<Employee> employees) {
        return algorithm.assignTask(task, employees);
    }
}

