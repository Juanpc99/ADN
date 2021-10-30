package com.ceiba.espacio.servicio.testDataBuilder;

import com.ceiba.espacio.modelo.entidad.Espacio;

public class EspacioTestDataBuilder {

    private Long id;
    private String nombre;
    private String estado;

    public EspacioTestDataBuilder(){
        this.nombre = "A12";
        this.estado = "D";

    }
    public EspacioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public EspacioTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public EspacioTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }

    public Espacio build(){
        return new Espacio(id, nombre, estado);
    }
}
