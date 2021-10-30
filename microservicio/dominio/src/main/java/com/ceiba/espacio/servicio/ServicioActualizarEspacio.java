package com.ceiba.espacio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;

public class ServicioActualizarEspacio {

    private static final String EL_ESPACIO_NO_EXISTE_EN_EL_SISTEMA = "El espacio no existe en el sistema";

    private final RepositorioEspacio repositorioEspacio;

    public ServicioActualizarEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }

    public void  ejecutar(Espacio espacio) {
        validarExistenciaPrevia(espacio);
        this.repositorioEspacio.actualizar(espacio);
    }

    private void validarExistenciaPrevia(Espacio espacio) {
        boolean existe = this.repositorioEspacio.existePorId(espacio.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_ESPACIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
