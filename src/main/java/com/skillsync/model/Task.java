package com.skillsync.model;

import com.skillsync.model.enums.TaskPriority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private String requiredSkill;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private double estimatedHours;

    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;

    private String status = "active";
}
