CREATE TABLE alojamiento (
    id               INT(10) NOT NULL,
    nombre           VARCHAR(100),
    num_banos        INT(1),
    ubicacion        VARCHAR(200),
    num_habitaciones VARCHAR(1),
    es_habitacion    CHAR(1)
);

ALTER TABLE alojamiento ADD CONSTRAINT alojamiento_pk PRIMARY KEY ( id );

CREATE TABLE apartamento (
    id               INT(10) NOT NULL,
    num_habitaciones INT(1)
);

ALTER TABLE apartamento ADD CONSTRAINT apartamento_pk PRIMARY KEY ( id );

CREATE TABLE cosas_que_faltan (
    id              VARCHAR(10) NOT NULL,
    toallas_p       CHAR(1),
    toallas_g       CHAR(1),
    gel             CHAR(1),
    champu          CHAR(1),
    funda_edredon   CHAR(1),
    lejia           CHAR(1),
    sabana_bajera   CHAR(1),
    funda_almohada  CHAR(1),
    papel_higienico CHAR(1),
    salida_id       INT(10)
);

CREATE UNIQUE INDEX cosas_que_faltan__idx ON
    cosas_que_faltan (
        salida_id
    ASC );

ALTER TABLE cosas_que_faltan ADD CONSTRAINT cosas_que_faltan_pk PRIMARY KEY ( id );

CREATE TABLE empleado (
    dni              VARCHAR(10) NOT NULL,
    nombre           VARCHAR(50),
    email            VARCHAR(100),
    sueldo_por_horas INT(2),
    contrasena       VARCHAR(100),
    activo           CHAR(1)
);

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( dni );

CREATE TABLE relation_1 (
    empleado_dni VARCHAR(10) NOT NULL,
    salida_id    INT(10) NOT NULL
);

ALTER TABLE relation_1 ADD CONSTRAINT relation_1_pk PRIMARY KEY ( empleado_dni,
                                                                  salida_id );

CREATE TABLE salida (
    id                      INT(10) NOT NULL,
    num_personas            INT(2),
    mascotas                CHAR(1),
    ninos                   CHAR(1),
    fechaentrada            DATE,
    tareas_mantenimiento_id VARCHAR(10),
    tareas_limpiadora_id    VARCHAR(10),
    cosas_que_faltan_id     VARCHAR(10),
    alojamiento_id          INT(10)
);

CREATE UNIQUE INDEX salida__idx ON
    salida (
        tareas_mantenimiento_id
    ASC );

CREATE UNIQUE INDEX salida__idxv1 ON
    salida (
        tareas_limpiadora_id
    ASC );

CREATE UNIQUE INDEX salida__idxv2 ON
    salida (
        cosas_que_faltan_id
    ASC );

ALTER TABLE salida ADD CONSTRAINT salida_pk PRIMARY KEY ( id );

CREATE TABLE tareas_limpiadora (
    id              VARCHAR(10) NOT NULL,
    limpieza_normal CHAR(1),
    cocina_extra    CHAR(1),
    balcon_extra    CHAR(1),
    cristales_extra CHAR(1),
    hacer_cama      CHAR(1),
    salida_id       INT(10)
);

CREATE UNIQUE INDEX tareas_limpiadora__idx ON
    tareas_limpiadora (
        salida_id
    ASC );

ALTER TABLE tareas_limpiadora ADD CONSTRAINT tareas_limpiadora_pk PRIMARY KEY ( id );

CREATE TABLE tareas_mantenimiento (
    id                VARCHAR(10) NOT NULL,
    grifo_roto        CHAR(1),
    ducha_rota        CHAR(1),
    lampara_rota      CHAR(1),
    persiana_rota     CHAR(1),
    pintar            CHAR(1),
    reponer_bombillas CHAR(1),
    salida_id         INT(10)
);

CREATE UNIQUE INDEX tareas_mantenimiento__idx ON
    tareas_mantenimiento (
        salida_id
    ASC );

ALTER TABLE tareas_mantenimiento ADD CONSTRAINT tareas_mantenimiento_pk PRIMARY KEY ( id );

ALTER TABLE apartamento
    ADD CONSTRAINT apartamento_alojamiento_fk FOREIGN KEY ( id )
        REFERENCES alojamiento ( id );

ALTER TABLE cosas_que_faltan
    ADD CONSTRAINT cosas_que_faltan_salida_fk FOREIGN KEY ( salida_id )
        REFERENCES salida ( id );

ALTER TABLE relation_1
    ADD CONSTRAINT relation_1_empleado_fk FOREIGN KEY ( empleado_dni )
        REFERENCES empleado ( dni );

ALTER TABLE relation_1
    ADD CONSTRAINT relation_1_salida_fk FOREIGN KEY ( salida_id )
        REFERENCES salida ( id );

ALTER TABLE salida
    ADD CONSTRAINT salida_alojamiento_fk FOREIGN KEY ( alojamiento_id )
        REFERENCES alojamiento ( id );

ALTER TABLE salida
    ADD CONSTRAINT salida_cosas_que_faltan_fk FOREIGN KEY ( cosas_que_faltan_id )
        REFERENCES cosas_que_faltan ( id );

ALTER TABLE salida
    ADD CONSTRAINT salida_tareas_limpiadora_fk FOREIGN KEY ( tareas_limpiadora_id )
        REFERENCES tareas_limpiadora ( id );

ALTER TABLE salida
    ADD CONSTRAINT salida_tareas_mantenimiento_fk FOREIGN KEY ( tareas_mantenimiento_id )
        REFERENCES tareas_mantenimiento ( id );

ALTER TABLE tareas_limpiadora
    ADD CONSTRAINT tareas_limpiadora_salida_fk FOREIGN KEY ( salida_id )
        REFERENCES salida ( id );

ALTER TABLE tareas_mantenimiento
    ADD CONSTRAINT tareas_mantenimiento_salida_fk FOREIGN KEY ( salida_id )
        REFERENCES salida ( id );
		
INSERT INTO EMPLEADO (DNI, NOMBRE, CONTRASENA) VALUES ('1234', 'ALEJANDRA', '1234');

INSERT INTO ALOJAMIENTO VALUES ('1', 'APARTAMENTO CORAL', 2, 'C/ AXARQUIA, 2', 3, 0);
INSERT INTO ALOJAMIENTO VALUES ('2', 'CASA FRANCISCA', 1, 'C/ CASTILLA PÉREZ, 4', 2, 0);
INSERT INTO ALOJAMIENTO VALUES ('3', 'APARTAMENTO ARMIJO', 2, 'C/ PINTADA, 7', 4, 0);