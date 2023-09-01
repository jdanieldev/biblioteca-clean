package com.ceiba.biblioteca.nucleo.prestamo.dominio.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class GenerarPrestamoInput {

    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;

}
