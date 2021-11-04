package com.ceiba.espacio.modelo.entidad;



import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


public class Espacio {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";


    private Long id;
    private String nombre;
    private String estado;

    public Espacio(Long id, String nombre, String estado){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);


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
