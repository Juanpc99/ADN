package com.ceiba.vehiculo.modelo.dto;



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


}
