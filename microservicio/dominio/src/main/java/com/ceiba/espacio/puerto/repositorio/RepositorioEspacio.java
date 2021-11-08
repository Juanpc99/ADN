package com.ceiba.espacio.puerto.repositorio;

import com.ceiba.espacio.modelo.entidad.Espacio;

public interface RepositorioEspacio {

    /**
     * Permite crear un espacio
     * @param espacio
     * @return el id generado
     */
    Long crear(Espacio espacio);

    /**
     * Permite actualizar un espacio
     * @param espacio
     */
    void actualizar(Espacio espacio);

    /**
     * Permite actualizar el estado
     * @param espacio
     */
    void actualizarEstado(Long id, String estado);

    /**
     * Permite eliminar un espacio
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un espacio con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un espacio con un nombre excluyendo un id
     * @param id
     * @return
     */
    boolean existePorId(Long id);
}
