package com.skillsync.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentDTO {
    private Long taskId;
    private Long employeeId;
    private String estado;
    private LocalDateTime fechaAsignacion;
}
