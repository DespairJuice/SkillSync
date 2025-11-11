package com.skillsync.ml.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureVector {
    private double disponibilidad;
    private double productividad;
    private double experiencia; // se puede derivar de tareas completadas
    private double prioridadTarea;
    private double horasEstimadas;
}
