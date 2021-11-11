package com.ceiba.vehiculo.controlador;

import com.ceiba.vehiculo.consulta.ManejadorListarPorPlacaVehiculo;
import com.ceiba.vehiculo.consulta.ManejadorListarVehiculo;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@Api(tags = {"Controlador consulta vehiculo"})
public class ConsultaControladorVehiculo {

    private final ManejadorListarVehiculo manejadorListarVehiculo;
    private final ManejadorListarPorPlacaVehiculo manejadorListarPorPlacaVehiculo;

    public ConsultaControladorVehiculo(ManejadorListarVehiculo manejadorListarVehiculo,
                                       ManejadorListarPorPlacaVehiculo manejadorListarPorPlacaVehiculo) {
        this.manejadorListarVehiculo = manejadorListarVehiculo;
        this.manejadorListarPorPlacaVehiculo = manejadorListarPorPlacaVehiculo;
    }

    @GetMapping
    @ApiOperation("Listar vehiculo")
    public List<DtoVehiculo> list(){ return this.manejadorListarVehiculo.ejecutar();}

    @GetMapping("/{placa}")
    @ApiOperation("Listar vehiculos por placa")
    public List<DtoVehiculo> lisatrPorPlaca(@PathVariable String placa){
        return this.manejadorListarPorPlacaVehiculo.ejecutar(placa);
    }

}
