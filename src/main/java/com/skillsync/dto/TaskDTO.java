package com.skillsync.dto;

import com.skillsync.model.enums.TaskPriority;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String requiredSkill;
    private TaskPriority priority;
    private double estimatedHours;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private String status;
}