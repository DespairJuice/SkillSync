package com.skillsync.algorithm;

import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;
import org.springframework.stereotype.Component;

@Component
public class DefaultScoringStrategy implements ScoringStrategy {

    @Override
    public double calculateScore(Employee employee, Task task) {
        double skillMatch = employee.matchSkill(task.getRequiredSkill()); // 0–1
        double availability = employee.getDisponibilidad(); // 0–1
        double priorityWeight = getPriorityWeight(task.getPriority()); // prioriza tareas críticas
        double cargoSimilarity = calculateCargoSimilarity(employee.getCargo(), task.getRequiredSkill()); // 0–0.5
        double productivity = employee.getProductividad(); // 0–1

        return (skillMatch * 0.4) + (availability * 0.2) + (cargoSimilarity * 0.2) + (productivity * 0.1) + priorityWeight;
    }

    private double calculateCargoSimilarity(String cargo, String requiredSkill) {
        if (cargo == null || requiredSkill == null) return 0.0;
        if (cargo.toLowerCase().contains(requiredSkill.toLowerCase()) ||
            requiredSkill.toLowerCase().contains(cargo.toLowerCase())) {
            return 0.5;
        }
        return 0.0;
    }

    private double getPriorityWeight(TaskPriority priority) {
        switch (priority) {
            case BAJA:
                return 0.0;
            case MEDIA:
                return 0.1;
            case ALTA:
                return 0.15;
            case CRITICA:
                return 0.2;
            default:
                return 0.0;
        }
    }
}
