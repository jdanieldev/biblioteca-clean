package com.ceiba.biblioteca.converter.nucleo.excepcion;

public class NotFoundExcepcion extends RuntimeException {

    private String mensaje;

    public NotFoundExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

}
