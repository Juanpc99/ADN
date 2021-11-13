package com.ceiba.vehiculo.consulta;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarIdEspacioVehiculo {
    private final DaoVehiculo daoVehiculo;

    public ManejadorBuscarIdEspacioVehiculo(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public DtoVehiculo ejecutar(Long idEspacio){ return this.daoVehiculo.buscarPorIdEspacio(idEspacio); }
}
