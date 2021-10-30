package com.ceiba.espacio.comando.manejador;

import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEspacio {

    private final ServicioEliminarEspacio servicioEliminarEspacio;

    public ManejadorEliminarEspacio(ServicioEliminarEspacio servicioEliminarEspacio){
        this.servicioEliminarEspacio = servicioEliminarEspacio;
    }

    public void ejecutar(Long id){
        this.servicioEliminarEspacio.ejecutar(id);
    }
}
