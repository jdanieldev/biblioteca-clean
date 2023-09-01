package com.ceiba.biblioteca.application.web;


import com.ceiba.biblioteca.controlador.PrestamoControlador;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.input.ConsultarPrestamoInput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.input.GenerarPrestamoInput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.output.ConsultarPrestamoOutput;
import com.ceiba.biblioteca.nucleo.prestamo.dominio.output.GenerarPrestamoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prestamo")
public class SpringController {

    @Autowired
    private PrestamoControlador prestamoControlador;

    @PostMapping()
    public ResponseEntity<GenerarPrestamoOutput> generarPrestamo(
            @RequestBody GenerarPrestamoInput generarPrestamoInput
    ) {
        final GenerarPrestamoOutput output = prestamoControlador.generarPrestamo(generarPrestamoInput);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @GetMapping("/{id-prestamo}")
    public ResponseEntity<ConsultarPrestamoOutput> consultarPrestamo(
            @PathVariable("id-prestamo") Long id
    ) {
        final ConsultarPrestamoOutput output = prestamoControlador.consultarPrestamo(new ConsultarPrestamoInput(id));

        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}

