package com.ceiba.biblioteca.repositorio.sql;

import com.ceiba.biblioteca.nucleo.prestamo.dominio.Prestamo;

public interface PrestamoSqlRepository {

    Prestamo findById(Long id);
    Prestamo save(Prestamo prestamo);
    Prestamo findByIdentificacionUsuario(String identificacionUsuario);

}
