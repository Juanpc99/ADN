package com.ceiba.espacio.adaptador.repositorio;

import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspacioPostgres implements RepositorioEspacio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "espacio", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "espacio", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "espacio", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "espacio", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "espacio", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioEspacioPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Espacio espacio) {
        return this.customNamedParameterJdbcTemplate.crear(espacio, sqlCrear);
    }

    @Override
    public void actualizar(Espacio espacio) {
        this.customNamedParameterJdbcTemplate.actualizar(espacio, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id" ,id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, parameterSource, Boolean.class);
    }
}
