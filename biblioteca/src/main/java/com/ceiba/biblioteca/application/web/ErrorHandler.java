package com.ceiba.biblioteca.application.web;

import com.ceiba.biblioteca.nucleo.excepcion.BadRequestExcepcion;
import com.ceiba.biblioteca.nucleo.excepcion.BibliotecaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<BibliotecaError> handle404(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BibliotecaError("No existe el préstamo"));
    }

    @ExceptionHandler(BadRequestExcepcion.class)
    public ResponseEntity<BibliotecaError> handle400(BadRequestExcepcion ex) {
        return ResponseEntity.badRequest().body(new BibliotecaError(ex.getMessage()));
    }

}
