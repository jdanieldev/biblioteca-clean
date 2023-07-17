package com.ceiba.biblioteca.repositorio.sql.dao;

import com.ceiba.biblioteca.repositorio.sql.dominio.PrestamoSql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrestamoSqlDao extends CrudRepository<PrestamoSql, Long> {

    PrestamoSql save(PrestamoSql prestamoSql);
    PrestamoSql findPrestamoSqlByIdentificacionUsuario(String identificacionUsuario);

}
