package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVehiculoPostgres implements DaoVehiculo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "vehiculo", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "vehiculo", value = "buscarId")
    private static String sqlBuscarId;

    @SqlStatement(namespace = "vehiculo", value = "buscarPorPlaca")
    private static String sqlBuscarPorPlaca;

    @SqlStatement(namespace = "vehiculo", value = "buscarPorIdEspacio")
    private static String sqlBuscarIdEspacio;

    public DaoVehiculoPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVehiculo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVehiculo());
    }

    @Override
    public DtoVehiculo buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarId, paramSource, new MapeoVehiculo()).stream().findFirst().get();
    }

    @Override
    public List<DtoVehiculo> listarPorPlaca(String placa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", placa);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorPlaca, paramSource, new MapeoVehiculo());
    }

    @Override
    public DtoVehiculo buscarPorIdEspacio(Long idEspacio) {
       MapSqlParameterSource parameterSource = new MapSqlParameterSource();
       parameterSource.addValue("idEspacio", idEspacio);
       return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarIdEspacio, parameterSource, new MapeoVehiculo()).stream().findFirst().get();
    }

}
