package com.skillsync.ml;

import com.skillsync.ml.features.FeatureVector;
import org.springframework.stereotype.Component;

@Component
public class AssignmentPredictor {

    /**
     * Calcula una puntuación heurística para evaluar la compatibilidad entre empleado y tarea.
     * 
     * @param vector características combinadas del empleado y la tarea
     * @return puntuación de 0 a 1
     */
    public double predictCompatibility(FeatureVector vector) {
        double pesoDisponibilidad = 0.25;
        double pesoProductividad = 0.35;
        double pesoExperiencia = 0.2;
        double pesoPrioridad = 0.1;
        double pesoHoras = 0.1;

        double score =
                vector.getDisponibilidad() * pesoDisponibilidad +
                vector.getProductividad() * pesoProductividad +
                vector.getExperiencia() * pesoExperiencia +
                vector.getPrioridadTarea() * pesoPrioridad -
                (vector.getHorasEstimadas() / 40.0) * pesoHoras;

        return Math.max(0, Math.min(1, score)); // limitar entre 0 y 1
    }
}
