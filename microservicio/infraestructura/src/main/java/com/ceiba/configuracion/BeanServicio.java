package com.ceiba.configuracion;

import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.espacio.servicio.ServicioActualizarEspacio;
import com.ceiba.espacio.servicio.ServicioCrearEspacio;
import com.ceiba.espacio.servicio.ServicioEliminarEspacio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
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
	

}
