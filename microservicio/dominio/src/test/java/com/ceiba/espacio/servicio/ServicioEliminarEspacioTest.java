package com.ceiba.espacio.servicio;

import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarEspacioTest {

    @Test
    @DisplayName("Deberia eliminar el espacio llamando al repositorio")
    void deberiaElminarElEspacioLlamandoAlRepositorio(){
        // arrange
        RepositorioEspacio repositorioEspacio = Mockito.mock(RepositorioEspacio.class);
        ServicioEliminarEspacio servicioEliminarEspacio  = new ServicioEliminarEspacio(repositorioEspacio);
        // act
        servicioEliminarEspacio.ejecutar(1L);
        // assert
        Mockito.verify(repositorioEspacio, Mockito.times(1)).eliminar(1L);
    }
}
