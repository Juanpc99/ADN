package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class DtoVehiculo {
    private Long id;
    private String placa;
    private Long idEspacio;
    private String tipoVehiculo;
    private String modeloVehiculo;
    private String nombrePropietario;
    private String apellidoPropietario;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Double totalPagar;
    private Double precioBaseHora;
}
