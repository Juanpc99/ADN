package com.ceiba.espacio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class DtoEspacio {
    private Long id;
    private String nombre;
    private String estado;

    public DtoEspacio(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
}
