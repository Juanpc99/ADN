package com.ceiba.espacio.servicio.testbuilder;

import com.ceiba.espacio.comando.ComandoEspacio;


public class ComandoEspacioTestDataBuilder {
    private static final Integer MAXIMO_DE_CARACTERES = 3;

    private Long id;
    private String nombre;
    private String estado;

    public ComandoEspacioTestDataBuilder(){
        this.nombre = "A99";
        this.estado = "A";
    }
    public ComandoEspacioTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ComandoEspacioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ComandoEspacio build(){
        return new ComandoEspacio(id, nombre, estado);
    }
}
