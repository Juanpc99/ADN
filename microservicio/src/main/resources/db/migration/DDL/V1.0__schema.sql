CREATE TABLE espacio
(
 id         serial NOT NULL,
 nombre     varchar(3) NOT NULL UNIQUE,
 estado     varchar(1) NOT NULL,
 CONSTRAINT PK_17 PRIMARY KEY ( id )
);


CREATE TABLE vehiculo
(
 id                   serial   NOT NULL,
 placa                varchar(6) NOT NULL,
 id_espacio           integer NOT NULL,
 tipo_vehiculo        varchar(50) NOT NULL,
 modelo_vehiculo      varchar(50) NOT NULL,
 nombre_propietario   varchar(50) NOT NULL,
 apellido_propietario varchar(50) NOT NULL,
 fecha_entrada        date  NULL,
 fecha_salida         date  NULL,
 total_pagar          integer NULL,
 precio_base_hora     integer NOT NULL,
 CONSTRAINT PK_31 PRIMARY KEY ( id ),
 CONSTRAINT FK_28 FOREIGN KEY ( id_espacio ) REFERENCES espacio ( id )
);