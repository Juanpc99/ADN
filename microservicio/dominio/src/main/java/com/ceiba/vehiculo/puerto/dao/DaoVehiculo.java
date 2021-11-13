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
     *Permite buscar por id
     * @param id
     * @return
     */
    DtoVehiculo buscarPorId(Long id);

    /**
     * Permite listar por placa
     * @param placa
     * @return
     */
    List<DtoVehiculo> listarPorPlaca(String placa);

    /**
     * Permite buscar por id espacio
     * @param idEspacio
     * @return
     */
    DtoVehiculo buscarPorIdEspacio(Long idEspacio);
}
