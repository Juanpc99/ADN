package com.ceiba.espacio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.testDataBuilder.EspacioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarEspacioTest {

    @Test
    @DisplayName("Debera validar la existencia previa del espacio")
    void debraValidarLaExistenciaPreviaDelEspacio(){
        //Arrange
        Espacio espacio = new EspacioTestDataBuilder().conId(1L).build();
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioEspacio.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarEspacio servicioActualizarEspacio = new ServicioActualizarEspacio(repositorioEspacio);
        //Act - assert
        BasePrueba.assertThrows(() -> servicioActualizarEspacio.ejecutar(espacio), ExcepcionDuplicidad.class, "El espacio no existe en el sistema");

    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio(){
        // arrange
        Espacio espacio = new EspacioTestDataBuilder().conId(1L).build();
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        Mockito.when(repositorioEspacio.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarEspacio servicioActualizarEspacio = new ServicioActualizarEspacio(repositorioEspacio);
        // act
        servicioActualizarEspacio.ejecutar(espacio);
        // assert
        Mockito.verify(repositorioEspacio, Mockito.times(1)).actualizar(espacio);
    }

}
