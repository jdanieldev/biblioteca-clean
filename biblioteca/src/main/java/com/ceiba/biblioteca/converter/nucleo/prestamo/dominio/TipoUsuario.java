package com.ceiba.biblioteca.converter.nucleo.prestamo.dominio;

import com.ceiba.biblioteca.converter.nucleo.excepcion.BadRequestExcepcion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
public enum TipoUsuario {

    AFILIADO(1), EMPLEADO(2), INVITADO(3);

    @Getter private Integer id;

    static public TipoUsuario valueOf(Integer id) {
        final Optional<TipoUsuario> tipoUsuario = Arrays.stream(TipoUsuario.values())
                .filter(t -> t.getId() == id)
                .findFirst();

        if (!tipoUsuario.isPresent()) {
            throw new BadRequestExcepcion("Tipo de usuario no permitido en la biblioteca");
        }

        return tipoUsuario.get();
    }

}
