package com.ceiba.biblioteca.converter.nucleo.excepcion;

public class BadRequestExcepcion extends RuntimeException {

    public BadRequestExcepcion(String mensaje) {
        super(mensaje);
    }

}
