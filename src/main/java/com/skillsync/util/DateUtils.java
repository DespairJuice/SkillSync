package com.skillsync.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 📅 Convierte LocalDateTime a String legible
    public static String formatDate(LocalDateTime date) {
        return date != null ? date.format(FORMATTER) : null;
    }

    // ⏱️ Calcula diferencia en horas entre dos fechas
    public static long hoursBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }

    // 📆 Obtiene la fecha actual formateada
    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
