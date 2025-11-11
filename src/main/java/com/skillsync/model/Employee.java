package com.skillsync.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cargo;
    private String email;
    private String telefono;

    /**
     * Porcentaje de disponibilidad actual (0–1)
     * 1 = completamente disponible, 0 = ocupado.
     */
    private double disponibilidad;

    /**
     * Promedio de productividad basado en tareas previas (0–1)
     */
    private double productividad;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills;

    // Método para calcular coincidencia de habilidades con similitud
    public double matchSkill(String requiredSkill) {
        if (requiredSkill == null || requiredSkill.isEmpty()) return 0.0;
        return skills.stream()
                .filter(s -> s.getNombre().toLowerCase().contains(requiredSkill.toLowerCase()) ||
                        requiredSkill.toLowerCase().contains(s.getNombre().toLowerCase()))
                .mapToDouble(s -> s.getNivel().getValue() / 5.0)
                .max()
                .orElse(0.0);
    }
}
