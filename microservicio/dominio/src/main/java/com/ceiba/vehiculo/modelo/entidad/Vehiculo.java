package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Vehiculo {
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_EL_ID_ESPACIO = "Se debe ingresar el id espacio";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO = "Se debe ingresar el tipo de vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO = "Se debe ingresar el modelo del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_PROPIETARIO = "Se debe ingresar el apellido del propietario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_ENTRADA = "Se debe ingresar la fecha de entrada del vehiculo";
    private static final String SE_DEBE_INGRESA_EL_PRECIO_BASE_POR_HORA = "Se debe ingresar el precio base por hora";
    private static final String EL_ESTACIONAMIENTO_TODAVIA_NO_ABRE = "El estacionamiento todavia no abre";
    private static final String EL_ESTACIONAMIENTO_YA_CERRO = "El estacionamiento ya cerro";

    private static final Integer HORA_INICIO_JORNADA = 6;
    private static final Integer HORA_FIN_JORNADA = 23;


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

        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(idEspacio, SE_DEBE_INGRESAR_EL_ID_ESPACIO);
        validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
        validarObligatorio(modeloVehiculo, SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO);
        validarObligatorio(nombrePropietario, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO);
        validarObligatorio(apellidoPropietario, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_PROPIETARIO);
        validarObligatorio(fechaEntrada, SE_DEBE_INGRESAR_LA_FECHA_ENTRADA);
        validarObligatorio(precioBaseHora, SE_DEBE_INGRESA_EL_PRECIO_BASE_POR_HORA);
        validarMenor(HORA_INICIO_JORNADA, fechaEntrada.getHour(), EL_ESTACIONAMIENTO_TODAVIA_NO_ABRE);
        validarMenor(fechaEntrada.getHour(), HORA_FIN_JORNADA, EL_ESTACIONAMIENTO_YA_CERRO);


        this.id = id;
        this.placa = placa;
        this.idEspacio = idEspacio;
        this.tipoVehiculo = tipoVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.totalPagar = calcularTotal(precioBaseHora, fechaEntrada, fechaSalida);
        this.precioBaseHora = precioBaseHora;
    }

    public Double calcularTotal(Double precioBaseHora, LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        Double total = 0.0;
        if(fechaSalida == null){
            return total;
        }
        else if(fechaEntrada.getHour() >= 18){
            Integer totalHoras = totalHoras(fechaEntrada, fechaSalida);
            return total = (totalHoras * precioBaseHora) + (precioBaseHora * totalHoras * 0.15);
        }
        else if(fechaEntrada.getDayOfWeek() == DayOfWeek.SATURDAY || fechaEntrada.getDayOfWeek() == DayOfWeek.SUNDAY){
            Integer totalHoras = totalHoras(fechaEntrada, fechaSalida);
            return total = (totalHoras * precioBaseHora) + (precioBaseHora * totalHoras * 0.25);
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
