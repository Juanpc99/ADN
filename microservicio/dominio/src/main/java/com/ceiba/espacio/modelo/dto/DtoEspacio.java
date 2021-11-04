package com.ceiba.espacio.modelo.dto;




public class DtoEspacio {
    private Long id;
    private String nombre;
    private String estado;

    public DtoEspacio(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }
}
