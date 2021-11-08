package com.ceiba.vehiculo.comando.manejador;

import com.ceiba.espacio.servicio.ServicioActualizarEstadoEspacio;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarVehiculo implements ManejadorComando<Long> {

    private final ServicioEliminarVehiculo servicioEliminarVehiculo;
    private final ServicioActualizarEstadoEspacio servicioActualizarEstadoEspacio;
    private final DaoVehiculo daoVehiculo;

    public ManejadorEliminarVehiculo(ServicioEliminarVehiculo servicioEliminarVehiculo,
                                     ServicioActualizarEstadoEspacio servicioActualizarEstadoEspacio,
                                     DaoVehiculo daoVehiculo) {
        this.servicioEliminarVehiculo = servicioEliminarVehiculo;
        this.servicioActualizarEstadoEspacio = servicioActualizarEstadoEspacio;
        this.daoVehiculo = daoVehiculo;
    }

    public void ejecutar(Long id) {
        DtoVehiculo vehiculo = daoVehiculo.buscarPorId(id);
        this.servicioActualizarEstadoEspacio.ejecutar(vehiculo.getIdEspacio(), "D");
        this.servicioEliminarVehiculo.ejecutar(id);}

}
