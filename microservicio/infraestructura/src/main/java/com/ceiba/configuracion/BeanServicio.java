package com.ceiba.configuracion;

import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.espacio.servicio.ServicioCrearEspacio;
import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ServicioActualizarVehiculo;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import com.ceiba.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioCrearEspacio servicioCrearEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioCrearEspacio(repositorioEspacio);
    }

    @Bean
    public ServicioEliminarEspacio servicioEliminarEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioEliminarEspacio(repositorioEspacio);
    }

    @Bean
    public ServicioActualizarEspacio servicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        return new ServicioActualizarEspacio(repositorioEspacio);
    }
    @Bean
    public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo,
                                                        RepositorioEspacio repositorioEspacio) {
        return new ServicioCrearVehiculo(repositorioVehiculo, repositorioEspacio);
    }

    @Bean
    public ServicioEliminarVehiculo servicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        return new ServicioEliminarVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioActualizarVehiculo servicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        return new ServicioActualizarVehiculo(repositorioVehiculo);
    }
	

}
