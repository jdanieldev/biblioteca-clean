package com.ceiba.biblioteca.nucleo.prestamo.dominio.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class GenerarPrestamoOutput {

    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechaMaximaDevolucion;

}
