package com.skillsync.ml.features;

import com.skillsync.model.Employee;
import com.skillsync.model.Task;
import com.skillsync.model.enums.TaskPriority;

public class FeatureExtractor {

    public static FeatureVector extract(Employee e, Task t) {
        double prioridad = switch (t.getPriority()) {
            case ALTA -> 1.0;
            case MEDIA -> 0.5;
            case BAJA -> 0.2;
            case CRITICA -> 1.5;
        };

        double experiencia = e.getSkills().size() * 0.1; // ejemplo simple

        return new FeatureVector(
                e.getDisponibilidad(),
                e.getProductividad(),
                experiencia,
                prioridad,
                t.getEstimatedHours()
        );
    }
}