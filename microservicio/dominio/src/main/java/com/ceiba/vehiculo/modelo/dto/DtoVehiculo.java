package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

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

    public DtoVehiculo(Long id, String placa, Long idEspacio, String tipoVehiculo,
                       String modeloVehiculo, String nombrePropietario,
                       String apellidoPropietario, LocalDateTime fechaEntrada,
                       LocalDateTime fechaSalida, Double totalPagar, Double precioBaseHora) {
        this.id = id;
        this.placa = placa;
        this.idEspacio = idEspacio;
        this.tipoVehiculo = tipoVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.totalPagar = totalPagar;
        this.precioBaseHora = precioBaseHora;
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public Long getIdEspacio() {
        return idEspacio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public Double getPrecioBaseHora() {
        return precioBaseHora;
    }
}
