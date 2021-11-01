package com.ceiba.espacio.servicio.testbuilder;

import com.ceiba.espacio.comando.ComandoEspacio;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class ComandoEspacioTestDataBuilder {
    private static final Integer MAXIMO_DE_CARACTERES = 3;

    private Long id;
    private String nombre;
    private String estado;

    public ComandoEspacioTestDataBuilder(){
        this.nombre = RandomStringUtils.random(MAXIMO_DE_CARACTERES, "asfaffasfsafsaf");
        this.estado = "A";
    }
    /**
    public ComandoEspacioTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
*/
    public ComandoEspacio build(){
        return new ComandoEspacio(id, nombre, estado);
    }
}
