package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
public class Vehiculo {

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

    public Vehiculo(Long id, String placa, Long idEspacio, String tipoVehiculo, String modeloVehiculo,
                    String nombrePropietario, String apellidoPropietario, LocalDateTime fechaEntrada,
                    LocalDateTime fechaSalida, Double precioBaseHora) {
        this.id = id;
        this.placa = placa;
        this.idEspacio = idEspacio;
        this.tipoVehiculo = tipoVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.fechaEntrada = LocalDateTime.now();
        this.fechaSalida = LocalDateTime.now();
        this.totalPagar = calcularTotal(precioBaseHora, fechaEntrada, fechaSalida);
        this.precioBaseHora = precioBaseHora;
    }

    public Double calcularTotal(Double precioBaseHora, LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        Double total = 0.0;
        if(fechaEntrada.getHour() >= 18){
            Integer totalHoras = totalHoras(fechaEntrada, fechaSalida);
            return total = (totalHoras * precioBaseHora) + (precioBaseHora * 0.15);
        }
        else if(fechaEntrada.getDayOfWeek() == DayOfWeek.SATURDAY || fechaEntrada.getDayOfWeek() == DayOfWeek.SUNDAY){
            Integer totalHoras = totalHoras(fechaEntrada, fechaSalida);
            return total = (totalHoras * precioBaseHora) + (precioBaseHora * 0.25);
        }else {
            Integer totalHoras = totalHoras(fechaEntrada, fechaSalida);
            return total = (totalHoras * precioBaseHora);
        }
    }
    public Integer totalHoras(LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        Integer horasEntrada = fechaEntrada.getHour();
        Integer horasSalida = fechaSalida.getHour();
        Integer totalHoras = horasSalida - horasEntrada;
        return totalHoras;
    }
}
