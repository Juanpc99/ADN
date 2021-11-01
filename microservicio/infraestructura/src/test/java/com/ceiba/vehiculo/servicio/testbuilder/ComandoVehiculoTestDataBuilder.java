package com.ceiba.vehiculo.servicio.testbuilder;

import com.ceiba.vehiculo.comando.ComandoVehiculo;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ComandoVehiculoTestDataBuilder {
    private static final Integer MAXIMO_DE_CARACTERES = 6;


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


    public ComandoVehiculoTestDataBuilder() {
        this.placa = RandomStringUtils.random(6 , "asdfghjkl12345zxcvbg");
        this.idEspacio = 2L;
        this.tipoVehiculo = "Carro";
        this.modeloVehiculo = "BMW 2013";
        this.nombrePropietario = "Camilo";
        this.apellidoPropietario = "Lopez";
        this.fechaEntrada = LocalDateTime.of(LocalDate.of(2021, 11, 1), LocalTime.of(10, 06));
        this.fechaSalida = LocalDateTime.of(LocalDate.of(2021, 11, 1), LocalTime.of(16, 06));
        this.precioBaseHora = 12000.0;
    }

    public ComandoVehiculo build(){
        return new ComandoVehiculo(id, placa, idEspacio, tipoVehiculo, modeloVehiculo, nombrePropietario,
        apellidoPropietario, fechaEntrada, fechaSalida, precioBaseHora
        );
    }
}


