package com.ceiba.espacio.controlador;

import com.ceiba.espacio.consulta.ManejadorListarEspacio;
import com.ceiba.espacio.consulta.ManejadorListarTodosEspacio;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador consulta espacio"})
public class ConsultaControladorEspacio {
    private final ManejadorListarEspacio manejadorListarEspacio;
    private final ManejadorListarTodosEspacio manejadorListarTodosEspacio;

    public ConsultaControladorEspacio(ManejadorListarEspacio manejadorListarEspacio, ManejadorListarTodosEspacio manejadorListarTodosEspacio) {
        this.manejadorListarEspacio = manejadorListarEspacio;
        this.manejadorListarTodosEspacio = manejadorListarTodosEspacio;
    }

    @GetMapping("/{estado}")
    @ApiOperation("Listar espacios por estado")
    public List<DtoEspacio> listarPorEstado(@PathVariable String estado){ return this.manejadorListarEspacio.ejecutar(estado);}

    @GetMapping
    @ApiOperation("Listar espacios")
    public List<DtoEspacio> listarr(){ return this.manejadorListarTodosEspacio.ejecutar();}
}
