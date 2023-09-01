package com.ceiba.biblioteca.repositorio.sql.adaptador;

import com.ceiba.biblioteca.nucleo.prestamo.dominio.Prestamo;
import com.ceiba.biblioteca.repositorio.sql.PrestamoSqlRepository;
import com.ceiba.biblioteca.repositorio.sql.dao.PrestamoSqlDao;
import com.ceiba.biblioteca.repositorio.sql.dominio.PrestamoSql;
import com.ceiba.biblioteca.util.Utils;


public class PrestamoSqlAdaptador implements PrestamoSqlRepository {


    private PrestamoSqlDao prestamoSqlDao;

    public PrestamoSqlAdaptador(PrestamoSqlDao prestamoSqlDao) {
        this.prestamoSqlDao = prestamoSqlDao;
    }


    @Override
    public Prestamo findById(Long id) {
        return Utils.mapearPrestamo(prestamoSqlDao.findById(id).get());
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        prestamo.setId(null);
        final PrestamoSql prestamoSql = Utils.mapearPrestamoSql(prestamo);
        prestamoSql.setId(prestamoSqlDao.save(prestamoSql).getId());

        return Utils.mapearPrestamo(prestamoSql);
    }

    @Override
    public Prestamo findByIdentificacionUsuario(String identificacionUsuario) {
        final PrestamoSql prestamoSql = prestamoSqlDao.findPrestamoSqlByIdentificacionUsuario(identificacionUsuario);

        return Utils.mapearPrestamo(prestamoSql);
    }

}
