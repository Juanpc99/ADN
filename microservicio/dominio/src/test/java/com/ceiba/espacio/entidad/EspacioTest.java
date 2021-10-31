package com.ceiba.espacio.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspacioTest {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";

    @Test
    @DisplayName("Deberia crear correctamente el espacio")
    void deberiaCrearCorrectamenteElEspacio(){
        //Arrange
        // act
        Espacio espacio = new EspacioTestDataBuilder().conId(1L).conNombre("A12").build();
        // assert
        assertEquals(1, espacio.getId());
        assertEquals("A12", espacio.getNombre());
        assertEquals("D", espacio.getEstado());
    }

    @Test
    void deberiaFallarSinNombre(){
        EspacioTestDataBuilder espacioTestDataBuilder = new EspacioTestDataBuilder().conNombre(null).conId(1L);

        BasePrueba.assertThrows(() -> {
            espacioTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE);
    }
    @Test
    void debeFallarSinEstado(){
        EspacioTestDataBuilder espacioTestDataBuilder = new EspacioTestDataBuilder().conId(1L).conEstado(null);

        BasePrueba.assertThrows(() -> {
            espacioTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,
                SE_DEBE_INGRESAR_EL_ESTADO);
    }
}
