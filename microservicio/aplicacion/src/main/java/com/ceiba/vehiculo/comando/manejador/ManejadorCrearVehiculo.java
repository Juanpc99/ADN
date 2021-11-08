package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.servicio.ServicioActualizarEstadoEspacio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.fabrica.FabricaVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVehiculo  implements ManejadorComandoRespuesta<ComandoVehiculo, ComandoRespuesta<Long>> {

    private final FabricaVehiculo fabricaVehiculo;
    private final ServicioCrearVehiculo servicioCrearVehiculo;
    private final ServicioActualizarEstadoEspacio servicioActualizarEstadoEspacio;

    public ManejadorCrearVehiculo(FabricaVehiculo fabricaVehiculo,
                                  ServicioCrearVehiculo servicioCrearVehiculo,
                                  ServicioActualizarEstadoEspacio servicioActualizarEstadoEspacio) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioCrearVehiculo = servicioCrearVehiculo;
        this.servicioActualizarEstadoEspacio = servicioActualizarEstadoEspacio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVehiculo comandoVehiculo) {
        Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
        this.servicioActualizarEstadoEspacio.ejecutar(comandoVehiculo.getIdEspacio(), "O");
        return new ComandoRespuesta<>(this.servicioCrearVehiculo.ejecutar(vehiculo));
    }
}
