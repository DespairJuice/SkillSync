package com.skillsync.dto;

import lombok.Data;
import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String nombre;
    private String cargo;
    private String email;
    private String telefono;
    private double disponibilidad;
    private double productividad;
    private List<SkillDTO> skills;
}
