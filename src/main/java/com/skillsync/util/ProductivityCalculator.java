package com.skillsync.util;

import com.skillsync.model.Assignment;

import java.util.List;

public class ProductivityCalculator {

    /**
     * Calcula la productividad promedio (0–1) según el número de tareas completadas.
     * 
     * @param assignments lista de asignaciones del empleado
     * @return productividad (entre 0.0 y 1.0)
     */
    public static double calcularProductividad(List<Assignment> assignments) {
        if (assignments == null || assignments.isEmpty()) return 0.0;

        long completadas = assignments.stream()
                .filter(a -> a.getEstado().equalsIgnoreCase("COMPLETADA"))
                .count();

        return (double) completadas / assignments.size();
    }

    /**
     * Calcula una métrica de carga laboral actual.
     * 
     * @param totalTareas total de tareas asignadas
     * @param horasEstimadas suma total de horas estimadas
     * @return carga relativa (0–1)
     */
    public static double calcularCarga(int totalTareas, double horasEstimadas) {
        if (totalTareas == 0) return 0.0;
        double carga = horasEstimadas / (totalTareas * 8); // 8h jornada base
        return Math.min(carga, 1.0);
    }
}