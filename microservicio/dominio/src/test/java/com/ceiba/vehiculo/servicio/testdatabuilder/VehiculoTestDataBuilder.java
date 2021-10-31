package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class VehiculoTestDataBuilder {

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

    public VehiculoTestDataBuilder() {

        this.placa = "ABC123";
        this.idEspacio = 1L;
        this.tipoVehiculo = "Carro";
        this.modeloVehiculo = "Mazda 3 2010";
        this.nombrePropietario = "Juan";
        this.apellidoPropietario = "Caro";
        this.fechaEntrada = LocalDateTime.of(LocalDate.of(2021, 10, 30), LocalTime.of(13, 32));
        this.fechaSalida = LocalDateTime.of(LocalDate.of(2021, 10, 30), LocalTime.of(15, 40));
        this.precioBaseHora = 15000.0;
    }

    public VehiculoTestDataBuilder conPlaca(String Placa){
        this.placa = placa;
        return this;
    }
    public VehiculoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public VehiculoTestDataBuilder conIdPEspacio(Long idEspacio){
        this.idEspacio = idEspacio;
        return this;
    }
    public VehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo){
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }
    public VehiculoTestDataBuilder conModeloVehiculo(String modeloVehiculo){
        this.modeloVehiculo = modeloVehiculo;
        return this;
    }
    public VehiculoTestDataBuilder conNombrePropietario(String nombrePropietario){
        this.nombrePropietario = nombrePropietario;
        return this;
    }
    public VehiculoTestDataBuilder conApellidoPropietario(String apellidoPropietario){
        this.apellidoPropietario = apellidoPropietario;
        return this;
    }
    public VehiculoTestDataBuilder conFechaEntrada(LocalDateTime fechaEntrada){
        this.fechaEntrada = fechaEntrada;
        return this;
    }
    public VehiculoTestDataBuilder conFechaSalida(LocalDateTime fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }
    public VehiculoTestDataBuilder conTotalPagar(Double totalPagar){
        this.totalPagar = totalPagar;
        return this;
    }
    public VehiculoTestDataBuilder conPrecioBaseHora(Double precioBaseHora){
        this.precioBaseHora = precioBaseHora;
        return this;
    }
    public Vehiculo build(){
        return new Vehiculo(id, placa, idEspacio, tipoVehiculo, modeloVehiculo, nombrePropietario, apellidoPropietario, fechaEntrada, fechaSalida, precioBaseHora);
    }

}
