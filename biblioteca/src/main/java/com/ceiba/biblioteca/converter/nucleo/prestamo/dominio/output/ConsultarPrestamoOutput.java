package com.ceiba.biblioteca.converter.nucleo.prestamo.dominio.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class ConsultarPrestamoOutput {

    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private Integer tipoUsuario;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechaMaximaDevolucion;

}
