package com.skillsync.util;

import com.skillsync.exception.BadRequestException;

public class ValidationUtils {

    public static void validarCampoObligatorio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new BadRequestException("El campo '" + nombreCampo + "' es obligatorio.");
        }
    }

    public static void validarValorPositivo(double valor, String nombreCampo) {
        if (valor < 0) {
            throw new BadRequestException("El campo '" + nombreCampo + "' debe ser un valor positivo.");
        }
    }

    public static void validarRango(double valor, double min, double max, String nombreCampo) {
        if (valor < min || valor > max) {
            throw new BadRequestException("El campo '" + nombreCampo + "' debe estar entre " + min + " y " + max + ".");
        }
    }
}
