package com.ceiba.espacio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.espacio.modelo.entidad.Espacio;
import com.ceiba.espacio.puerto.repositorio.RepositorioEspacio;

public class ServicioActualizarEstadoEspacio {
    private static final String EL_ESPACIO_NO_EXISTE_EN_EL_SISTEMA = "El espacio no existe en el sistema";


    private final RepositorioEspacio repositorioEspacio;

    public ServicioActualizarEstadoEspacio(RepositorioEspacio repositorioEspacio) {
        this.repositorioEspacio = repositorioEspacio;
    }
    public void ejecutar(Long id,  String estado){
        validarExistenciaPrevia(id);
        this.repositorioEspacio.actualizarEstado(id, estado);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioEspacio.existePorId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_ESPACIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
