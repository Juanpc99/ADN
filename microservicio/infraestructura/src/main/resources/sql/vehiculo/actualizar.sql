update vehiculo
set placa = :placa,
    id_espacio = :idEspacio,
    tipo_vehiculo =:tipoVehiculo,
    modelo_vehiculo =:modeloVehiculo,
    nombre_propietario = :nombrePropietario,
    apellido_propietario = :apellidoPropietario,
    fecha_entrada = :fechaEntrada,
    fecha_salida = :fechaSalida,
    precio_base_hora = :precioBaseHora,
    total_pagar = :totalPagar
where id = :id