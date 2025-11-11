package com.skillsync.model.enums;

import lombok.Getter;

@Getter
public enum SkillLevel {
    BASICO(1),
    INTERMEDIO(3),
    AVANZADO(5);

    private final int value;

    SkillLevel(int value) {
        this.value = value;
    }
}
