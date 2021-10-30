package com.ceiba.espacio.puerto.dao;

import com.ceiba.espacio.modelo.dto.DtoEspacio;

import java.util.List;

public interface DaoEspacio {

    /**
     * Permite listar los espacios
     * @return los espacios
     */
    List<DtoEspacio> listar();
}
