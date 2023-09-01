package com.ceiba.biblioteca.nucleo.excepcion;

public class BadRequestExcepcion extends RuntimeException {

    public BadRequestExcepcion(String mensaje) {
        super(mensaje);
    }

}
