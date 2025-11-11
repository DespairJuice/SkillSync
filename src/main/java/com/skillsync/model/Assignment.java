package com.skillsync.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDateTime fechaAsignacion = LocalDateTime.now();
    private String estado = "ASIGNADA";

    public Assignment(Task task, Employee employee) {
        this.task = task;
        this.employee = employee;
        this.fechaAsignacion = LocalDateTime.now();
        this.estado = "ASIGNADA";
    }
}