package com.skillsync.model;

import com.skillsync.model.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private SkillLevel nivel;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
