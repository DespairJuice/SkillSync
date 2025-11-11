package com.skillsync.dto;

import com.skillsync.model.enums.SkillLevel;
import lombok.Data;

@Data
public class SkillDTO {
    private Long id;
    private String nombre;
    private SkillLevel nivel;
}
