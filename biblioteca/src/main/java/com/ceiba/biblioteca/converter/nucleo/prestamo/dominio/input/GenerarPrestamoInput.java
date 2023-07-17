package com.ceiba.biblioteca.converter.nucleo.prestamo.dominio.input;

import com.ceiba.biblioteca.converter.nucleo.prestamo.dominio.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class GenerarPrestamoInput {

    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;

}
