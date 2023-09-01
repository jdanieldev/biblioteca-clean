package com.ceiba.biblioteca.converter;

import com.ceiba.biblioteca.nucleo.prestamo.dominio.TipoUsuario;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TipoUsuarioConverter implements AttributeConverter<TipoUsuario, Integer> {


    @Override
    public Integer convertToDatabaseColumn(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            return null;
        }

        return tipoUsuario.getId();
    }

    @Override
    public TipoUsuario convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }

        return Stream.of(TipoUsuario.values())
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
