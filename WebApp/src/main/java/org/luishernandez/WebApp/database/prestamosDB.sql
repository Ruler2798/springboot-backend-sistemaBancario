CREATE DATABASE sistema_bancario;

USE sistema_bancario;

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) NOT NULL UNIQUE,
    fecha_registro DATE NOT NULL
);

CREATE TABLE solicitudes_prestamo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto_solicitado DECIMAL(15,2) NOT NULL,
    plazo_meses INT NOT NULL,
    tasa_interes DECIMAL(5,2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha_solicitud DATE NOT NULL,
    cliente_id BIGINT NOT NULL,

    CONSTRAINT fk_solicitud_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES clientes(id)
);

CREATE TABLE prestamos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto DECIMAL(15,2) NOT NULL,
    plazo_meses INT NOT NULL,
    tasa_interes DECIMAL(5,2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    cliente_id BIGINT NOT NULL,
    solicitud_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT fk_prestamo_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES clientes(id),

    CONSTRAINT fk_prestamo_solicitud
        FOREIGN KEY (solicitud_id)
        REFERENCES solicitudes_prestamo(id)
);

CREATE TABLE pagos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto_pagado DECIMAL(15,2) NOT NULL,
    fecha_pago DATE NOT NULL,
    prestamo_id BIGINT NOT NULL,

    CONSTRAINT fk_pago_prestamo
        FOREIGN KEY (prestamo_id)
        REFERENCES prestamos(id)
);