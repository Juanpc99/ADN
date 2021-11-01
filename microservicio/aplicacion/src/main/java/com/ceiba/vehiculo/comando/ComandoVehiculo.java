package com.ceiba.vehiculo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVehiculo {
    private Long id;
    private String placa;
    private Long idEspacio;
    private String tipoVehiculo;
    private String modeloVehiculo;
    private String nombrePropietario;
    private String apellidoPropietario;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Double precioBaseHora;


}
