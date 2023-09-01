package com.ceiba.biblioteca.util;

import com.ceiba.biblioteca.nucleo.prestamo.dominio.Prestamo;
import com.ceiba.biblioteca.repositorio.sql.dominio.PrestamoSql;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utils {

    public static LocalDate sumarDiasSinSabadosNiDomingos(LocalDate fecha, int cantidadDias) {
        LocalDate result = fecha;
        int diasAgregados = 0;

        while (diasAgregados < cantidadDias) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }

        return result;
    }

    public static Prestamo mapearPrestamo(PrestamoSql prestamoSql) {
        if(prestamoSql != null) {
            return new Prestamo(
                    prestamoSql.getId(),
                    prestamoSql.getIsbn(),
                    prestamoSql.getIdentificacionUsuario(),
                    prestamoSql.getTipoUsuario(),
                    prestamoSql.getFechaMaximaDevolucion()
            );
        }

        return null;
    }

    public static PrestamoSql mapearPrestamoSql(Prestamo prestamo) {
        return new PrestamoSql(
                prestamo.getId(),
                prestamo.getIsbn(),
                prestamo.getIdentificacionUsuario(),
                prestamo.getTipoUsuario(),
                prestamo.getFechaMaximaDevolucion()
        );
    }
}
