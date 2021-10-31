package com.ceiba.espacio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearEspacioTest {


    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia del espacio")
    void deberiaLanzarUnaExcepcionCuandoSeValideLaExistenciaDelEspacio(){
        // arrange
        Espacio espacio = new EspacioTestDataBuilder().build();
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioEspacio.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearEspacio servicioCrearEspacio = new ServicioCrearEspacio(repositorioEspacio);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEspacio.ejecutar(espacio), ExcepcionDuplicidad.class, "El espacio ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear el espacio de maner carrecta")
    void debriaCrearElEspacioDeManeraCorrecta(){
        // arrange
        Espacio espacio = new EspacioTestDataBuilder().build();
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioEspacio.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioEspacio.crear(espacio)).thenReturn(10L);
        ServicioCrearEspacio servicioCrearEspacio = new ServicioCrearEspacio(repositorioEspacio);
        // act
        Long id = servicioCrearEspacio.ejecutar(espacio);
        // assert
        assertEquals(10L, id);
        Mockito.verify(repositorioEspacio, Mockito.times(1)).crear(espacio);
    }
}
