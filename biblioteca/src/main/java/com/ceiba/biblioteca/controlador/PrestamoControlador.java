package com.ceiba.biblioteca.controlador;

import com.ceiba.biblioteca.nucleo.prestamo.dominio.Prestamo;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.TipoUsuario;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.input.ConsultarPrestamoInput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.input.GenerarPrestamoInput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.output.ConsultarPrestamoOutput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.output.GenerarPrestamoOutput;
import com.ceiba.biblioteca.nucleo.prestamo.servicio.PrestamoServicio;

public class PrestamoControlador {

    PrestamoServicio prestamoServicio;

    public PrestamoControlador(PrestamoServicio prestamoServicio) {
        this.prestamoServicio = prestamoServicio;
    }

    public GenerarPrestamoOutput generarPrestamo(GenerarPrestamoInput request) {
        final Prestamo prestamo = prestamoServicio.crearPrestamo(
                request.getIsbn(),
                request.getIdentificacionUsuario(),
                TipoUsuario.valueOf(request.getTipoUsuario())
        );

        return new GenerarPrestamoOutput(prestamo.getId(), prestamo.getFechaMaximaDevolucion());
    }

    public ConsultarPrestamoOutput consultarPrestamo(ConsultarPrestamoInput request) {
        final Prestamo prestamo = prestamoServicio.getPrestamo(request.getId());

        return new ConsultarPrestamoOutput(
                prestamo.getId(),
                prestamo.getIsbn(),
                prestamo.getIdentificacionUsuario(),
                prestamo.getTipoUsuario().getId(),
                prestamo.getFechaMaximaDevolucion()
        );
    }

}
