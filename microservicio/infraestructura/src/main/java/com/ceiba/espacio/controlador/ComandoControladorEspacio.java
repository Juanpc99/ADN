package com.ceiba.espacio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.espacio.comando.ComandoEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorActualizarEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorCrearEspacio;
import com.ceiba.espacio.comando.manejador.ManejadorEliminarEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador comando usuario"})
public class ComandoControladorEspacio {

    private final ManejadorCrearEspacio manejadorCrearEspacio;
    private final ManejadorActualizarEspacio manejadorActualizarEspacio;
    private final ManejadorEliminarEspacio manejadorEliminarEspacio;

    @Autowired

    public ComandoControladorEspacio(ManejadorCrearEspacio manejadorCrearEspacio,
                                     ManejadorActualizarEspacio manejadorActualizarEspacio,
                                     ManejadorEliminarEspacio manejadorEliminarEspacio) {
        this.manejadorCrearEspacio = manejadorCrearEspacio;
        this.manejadorActualizarEspacio = manejadorActualizarEspacio;
        this.manejadorEliminarEspacio = manejadorEliminarEspacio;
    }

    @PostMapping
    @ApiOperation("Crear espacio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspacio comandoEspacio){
        return manejadorCrearEspacio.ejecutar(comandoEspacio);
    }

    @PutMapping(value = "{id}")
    @ApiOperation("Actualizar espacio")
    public void actualizar(@RequestBody ComandoEspacio comandoEspacio, @PathVariable Long id){
        comandoEspacio.setId(id);
        manejadorActualizarEspacio.ejecutar(comandoEspacio);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation("Eliminar espacio")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarEspacio.ejecutar(id);
    }
}
