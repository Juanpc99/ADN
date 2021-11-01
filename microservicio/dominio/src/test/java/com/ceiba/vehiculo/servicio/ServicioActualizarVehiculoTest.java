package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarVehiculoTest {

    private static final String EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA = "El vehiculo no existe en el sistema";


    @Test
    @DisplayName("Debe validar la existencia previa del vehiculo")
    void debeValidarLaExistenciaPreviaDelVehiculo(){
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);

        BasePrueba.assertThrows(()-> servicioActualizarVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class, EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA);
    }
    @Test
    @DisplayName("Deberia actualizar correctamente el vehiculo")
    void deberiaActualizarCorrectamenteElVehiculo(){
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);

        servicioActualizarVehiculo.ejecutar(vehiculo);

        Mockito.verify(repositorioVehiculo , Mockito.times(1)).actualizar(vehiculo);
    }
}
