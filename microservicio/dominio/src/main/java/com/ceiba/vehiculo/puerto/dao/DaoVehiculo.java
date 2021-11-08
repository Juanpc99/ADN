package com.ceiba.vehiculo.puerto.dao;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.util.List;

public interface DaoVehiculo {

    /**
     * Permite listar los vehiculos
     * @return lista de vehiculos
     */
    List<DtoVehiculo> listar();

    /**
     *
     * @param id
     * @return
     */
    DtoVehiculo buscarPorId(Long id);
}
