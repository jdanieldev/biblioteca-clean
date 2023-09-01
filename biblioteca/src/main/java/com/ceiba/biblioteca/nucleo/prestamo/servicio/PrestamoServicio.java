package com.ceiba.biblioteca.nucleo.prestamo.servicio;

import com.ceiba.biblioteca.nucleo.excepcion.BadRequestExcepcion;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.Prestamo;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.TipoUsuario;
import com.ceiba.biblioteca.repositorio.sql.PrestamoSqlRepository;
import com.ceiba.biblioteca.util.Utils;

import java.time.LocalDate;

public class PrestamoServicio {

    private PrestamoSqlRepository prestamoSqlRepository;

    public PrestamoServicio(PrestamoSqlRepository prestamoSqlRepository) {
        this.prestamoSqlRepository = prestamoSqlRepository;
    }

    public Prestamo crearPrestamo(String isbn, String identificacionUsuario, TipoUsuario tipoUsuario) {
        final int cantidadDias;
        switch (tipoUsuario) {
            case INVITADO:
                if (prestamoSqlRepository.findByIdentificacionUsuario(identificacionUsuario) != null) {
                    throw new BadRequestExcepcion("El usuario con identificación "
                            + identificacionUsuario
                            + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");
                } else {
                    cantidadDias = 7;
                }
                break;
            case EMPLEADO:
                cantidadDias = 8;
                break;
            case AFILIADO:
                cantidadDias = 10;
                break;
            default:
                throw new BadRequestExcepcion("Tipo de usuario no permitido en la biblioteca");
        }

        final LocalDate fechaDevolucion = Utils.sumarDiasSinSabadosNiDomingos(LocalDate.now(), cantidadDias);

        return prestamoSqlRepository.save(new Prestamo(null, isbn, identificacionUsuario, tipoUsuario, fechaDevolucion));
    }

    public Prestamo getPrestamo(Long idPrestamo) {
        return prestamoSqlRepository.findById(idPrestamo);
    }
}
