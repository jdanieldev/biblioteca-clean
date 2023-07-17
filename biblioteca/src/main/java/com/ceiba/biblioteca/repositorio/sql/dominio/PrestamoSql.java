package com.ceiba.biblioteca.repositorio.sql.dominio;

import com.ceiba.biblioteca.converter.nucleo.prestamo.dominio.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
@Data @NoArgsConstructor @AllArgsConstructor
public class PrestamoSql {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 10)
    private String isbn;

    @Column(precision = 10)
    private String identificacionUsuario;

    @Column(precision = 1)
    private TipoUsuario tipoUsuario;

    private LocalDate fechaMaximaDevolucion;

}
