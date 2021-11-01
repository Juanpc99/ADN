package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {
    private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
    private static final String EL_ESPACIO_NO_EXISTE_EN_EL_SITEMA = "El espacio no existe en el sistema";
    private static final String EL_ESPACIO_YA_ESTA_OCUPADO = "El espacio ya esta ocupado";

    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioEspacio repositorioEspacio;


    public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo,
                                 RepositorioEspacio repositorioEspacio) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioEspacio = repositorioEspacio;
    }

    public Long ejecutar(Vehiculo vehiculo) {
        validarExistenciaPrevia(vehiculo);
        validarExistenciaPreviaEspacio(vehiculo.getIdEspacio());
        validarExistenciaPreviaIdEspacio(vehiculo.getIdEspacio());
        return this.repositorioVehiculo.crear(vehiculo);
    }

    private void validarExistenciaPrevia(Vehiculo vehiculo) {
        boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaPreviaEspacio(Long id){
        boolean existe = this.repositorioEspacio.existePorId(id);
        if(!existe){
            throw new ExcepcionSinDatos(EL_ESPACIO_NO_EXISTE_EN_EL_SITEMA);
        }
    }

    private void validarExistenciaPreviaIdEspacio(Long id){
        boolean existe = this.repositorioVehiculo.existePorIdEspacio(id);
        if(existe){
            throw new ExcepcionDuplicidad(EL_ESPACIO_YA_ESTA_OCUPADO);
        }
    }
}
