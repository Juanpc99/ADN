package com.ceiba.espacio.consulta;

import com.ceiba.espacio.modelo.dto.DtoEspacio;
import com.ceiba.espacio.puerto.dao.DaoEspacio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPorIdEspacio {
    private final DaoEspacio daoEspacio;

    public ManejadorBuscarPorIdEspacio(DaoEspacio daoEspacio) {
        this.daoEspacio = daoEspacio;
    }
    public DtoEspacio ejecutar(Long id){ return this.daoEspacio.busacrPorId(id);}
}
