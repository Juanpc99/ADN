package com.ceiba.espacio.puerto.dao;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.modelo.entidad.Espacio;

import java.util.List;

public interface DaoEspacio {

    /**
     * Permite listar los espacios
     * @return los espacios
     */
    List<DtoEspacio> listar(String estado);

    /**
     * Permite listar todos los espacios
     * @return
     */
    List<DtoEspacio> listarTodos();


}
