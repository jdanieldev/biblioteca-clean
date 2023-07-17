package com.ceiba.biblioteca.converter.nucleo.prestamo.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class Prestamo {

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private TipoUsuario tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

}
