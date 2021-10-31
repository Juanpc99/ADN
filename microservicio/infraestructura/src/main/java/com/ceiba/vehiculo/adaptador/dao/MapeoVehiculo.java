package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoVehiculo implements RowMapper<DtoVehiculo>, MapperResult {

    @Override
    public DtoVehiculo mapRow(ResultSet rs, int rowNum) throws SQLException{
        Long id = rs.getLong("id");
        String placa = rs.getString("placa");
        Long idEspacio = rs.getLong("id_espacio");
        String tipoVehiculo = rs.getString("tipo_vehiculo");
        String modeloVehiculo = rs.getString("modelo_vehiculo");
        String nombrePropietario = rs.getString("nombre_propietario");
        String apellidoPropietario = rs.getString("apellido_propietario");
        LocalDateTime fechaEntrada = extraerLocalDateTime(rs, "fecha_entrada");
        LocalDateTime fechaSalida = extraerLocalDateTime(rs, "fecha_salida");
        Double totalPagar = rs.getDouble("total_pagar");
        Double precioBaseHora = rs.getDouble("precio_base_hora");

        return new DtoVehiculo(id, placa, idEspacio, tipoVehiculo, modeloVehiculo, nombrePropietario, apellidoPropietario, fechaEntrada, fechaSalida,
                totalPagar, precioBaseHora);

    }
}
/**
    private Long id;
    private String placa;
    private Long idEspacio;
    private String tipoVehiculo;
    private String modeloVehiculo;
    private String nombrePropietario;
    private String apellidoPropietario;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Double totalPagar;
    private Double precioBaseHora;
 */