package com.ceiba.espacio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEspacioPostgres implements DaoEspacio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "espacio", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "espacio", value = "listarTodo")
    private static String sqlListarTodo;

    public DaoEspacioPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoEspacio> listar(String estado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("estado", estado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource,new MapeoEspacio());
    }

    @Override
    public List<DtoEspacio> listarTodos() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTodo,new MapeoEspacio());
    }
}
