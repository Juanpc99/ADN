package com.ceiba.espacio.controlador;

import com.ceiba.espacio.consulta.ManejadorListarEspacio;
import com.ceiba.espacio.modelo.dto.DtoEspacio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/espacio")
@Api(tags = {"Controlador consulta espacio"})
public class ConsultaControladorEspacio {
    private final ManejadorListarEspacio manejadorListarEspacio;

    public ConsultaControladorEspacio(ManejadorListarEspacio manejadorListarEspacio){
        this.manejadorListarEspacio = manejadorListarEspacio;
    }

    @GetMapping
    @ApiOperation("Listar espacios")
    public List<DtoEspacio> listar(){ return this.manejadorListarEspacio.ejecutar();}
}
