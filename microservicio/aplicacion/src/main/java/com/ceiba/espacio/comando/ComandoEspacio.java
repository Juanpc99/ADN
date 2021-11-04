package com.ceiba.espacio.comando;



public class ComandoEspacio {

    private Long id;
    private String nombre;
    private String estado;

    public ComandoEspacio() {
    }

    public ComandoEspacio(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
