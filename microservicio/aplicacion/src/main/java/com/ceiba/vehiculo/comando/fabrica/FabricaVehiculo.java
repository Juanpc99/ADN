package com.ceiba.vehiculo.comando.fabrica;

import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaVehiculo {
    public Vehiculo crear(ComandoVehiculo comandoVehiculo){
        return new Vehiculo(
                comandoVehiculo.getId(),
                comandoVehiculo.getPlaca(),
                comandoVehiculo.getIdEspacio(),
                comandoVehiculo.getTipoVehiculo(),
                comandoVehiculo.getModeloVehiculo(),
                comandoVehiculo.getNombrePropietario(),
                comandoVehiculo.getApellidoPropietario(),
                comandoVehiculo.getFechaEntrada(),
                comandoVehiculo.getFechaSalida(),
                comandoVehiculo.getPrecioBaseHora()
        );
    }
}
