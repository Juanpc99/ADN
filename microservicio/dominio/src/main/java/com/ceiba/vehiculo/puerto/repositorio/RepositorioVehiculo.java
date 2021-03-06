package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {
    /**
     * Permite crear un vehiculo
     * @param vehiculo
     * @return el id generado
     */
    Long crear(Vehiculo vehiculo);

    /**
     * Permite actualizar un vehhiculo
     * @param vehiculo
     */
    void actualizar(Vehiculo vehiculo);

    /**
     * Permite eliminar un vehiculo
     * @param id
     */
    void eliminar(Long id);


    /**
     * Permite validar si existe un vehiculo con esa placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

    /**
     * Permite validar si existe un vehiculo con ese id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite validar si existe por el id de un espacio
     * @param id
     * @return si existe o no
     */
    boolean existePorIdEspacio(Long id);
}
