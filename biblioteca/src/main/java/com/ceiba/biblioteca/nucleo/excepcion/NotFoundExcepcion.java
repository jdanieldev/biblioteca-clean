package com.ceiba.biblioteca.nucleo.excepcion;

public class NotFoundExcepcion extends RuntimeException {

    private String mensaje;

    public NotFoundExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

}
