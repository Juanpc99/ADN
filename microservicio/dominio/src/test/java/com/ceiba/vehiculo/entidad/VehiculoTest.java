package com.ceiba.vehiculo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.espacio.servicio.testdatabuilder.EspacioTestDataBuilder;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {
    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_EL_ID_ESPACIO = "Se debe ingresar el id espacio";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO = "Se debe ingresar el tipo de vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO = "Se debe ingresar el modelo del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_PROPIETARIO = "Se debe ingresar el apellido del propietario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_ENTRADA = "Se debe ingresar la fecha de entrada del vehiculo";
    private static final String SE_DEBE_INGRESA_EL_PRECIO_BASE_POR_HORA = "Se debe ingresar el precio base por hora";
    private static final String EL_ESTACIONAMIENTO_TODAVIA_NO_ABRE = "El estacionamiento todavia no abre";




    @Test
    @DisplayName("Deberia crear correctamente el vehiculo")
    void deberiaCrearCorrectamenteElVehiculo(){
        //Arrange
        LocalDateTime fechaEntrada = LocalDateTime.of(LocalDate.of(2021, 10, 30), LocalTime.of(13, 32));
        LocalDateTime fechaSalida = LocalDateTime.of(LocalDate.of(2021, 10, 30), LocalTime.of(15, 40));
        // Act
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conId(1L).conPlaca("ABC123").build();
        //Assert
        assertEquals(1, vehiculo.getId());
        assertEquals("ABC123", vehiculo.getPlaca());
        assertEquals(fechaEntrada, vehiculo.getFechaEntrada());
        assertEquals(fechaSalida, vehiculo.getFechaSalida());
        assertEquals(37500, vehiculo.getTotalPagar());
        assertEquals(15000, vehiculo.getPrecioBaseHora());

    }
    @Test
    void debeFallarSinPlaca(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conPlaca(null);

        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
            }, ExcepcionValorObligatorio.class,
                SE_DEBE_INGRESAR_LA_PLACA);
    }
    @Test
    void debeFallarSinIdEspacio(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conIdPEspacio(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ID_ESPACIO);
    }
    @Test
    void debeFallarSinTipoVehiculo(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conTipoVehiculo(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_DE_VEHICULO);
    }
    @Test
    void debeFallarSinModeloVehiculo(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conModeloVehiculo(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_MODELO_DEL_VEHICULO);
    }
    @Test
    void debeFallarSinNombrePropietario(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conNombrePropietario(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PROPIETARIO);
    }
    @Test
    void debeFallarSinApellidoPrpietario(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conApellidoPropietario(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_PROPIETARIO);
    }
    @Test
    void debeFallarSinFechaEntrada(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conFechaEntrada(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_ENTRADA);
    }
    @Test
    void debeFallarSinPrecioBaseHora(){
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conPrecioBaseHora(null);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorObligatorio.class, SE_DEBE_INGRESA_EL_PRECIO_BASE_POR_HORA);
    }

    @Test
    void debeFallarSiHoraEntradaEsMenorAHoraApertura(){
        LocalDateTime horaInvalida =LocalDateTime.of(LocalDate.of(2021,12,12), LocalTime.of(5,30));

        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conId(1L).conFechaEntrada(horaInvalida);
        BasePrueba.assertThrows(() -> {
            vehiculoTestDataBuilder.build();
        },ExcepcionValorInvalido.class, EL_ESTACIONAMIENTO_TODAVIA_NO_ABRE);
    }


}
