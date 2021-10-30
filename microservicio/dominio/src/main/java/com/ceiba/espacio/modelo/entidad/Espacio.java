package com.ceiba.espacio.modelo.entidad;

import lombok.Getter;

import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Espacio {
    private static final String EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "El nombre debe tener una longitud igual a %s";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";
    private static final int LONGITUD_MINIMA_NOMBRE = 3;

    private Long id;
    private String nombre;
    private String estado;

    public Espacio(Long id, String nombre, String estado){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(estado, SE_DEBE_INGRESAR_EL_ESTADO);
        validarLongitud(nombre, LONGITUD_MINIMA_NOMBRE, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_IGUAL_A, LONGITUD_MINIMA_NOMBRE));

        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

}
