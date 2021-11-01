insert into espacio(id, nombre, estado) values(1, 'A00', 'D');
insert into espacio(id, nombre, estado) values(2, 'A01', 'D');

insert into vehiculo (id, placa, id_espacio, tipo_vehiculo, modelo_vehiculo, nombre_propietario, apellido_propietario,
                        fecha_entrada, fecha_salida, precio_base_hora, total_pagar)
                       values (1, 'ASD123', 1, 'Carro', 'Mazda', 'Juan', 'Caro', '2021-10-10 10:34:00',
                       '2021-10-10 12:34:00', 15000, 15000);

