package com.ceiba.espacio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.espacio.modelo.dto.DtoEspacio;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEspacio implements RowMapper<DtoEspacio>, MapperResult {


    @Override
    public DtoEspacio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String estado = rs.getString("estado");

        return new DtoEspacio(id, nombre, estado);
    }
}
