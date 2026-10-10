-- TABLAS
-- TABLA PERSONA

CREATE TABLE persona 
(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL
);


-- TABLA CLIENTE

CREATE TABLE cliente 
(
    id INT PRIMARY KEY,
    telefono VARCHAR(20) NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE
);


-- TABLA VETERINARIO

CREATE TABLE veterinario 
(
    id INT PRIMARY KEY,
    especialidad VARCHAR(50) NOT NULL,
    
    FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE
);


-- TABLA ANIMAL

CREATE TABLE animal 
(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50) NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);


-- TABLA CITA

CREATE TABLE cita 
(
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    cliente_id INT NOT NULL,
    veterinario_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE,
    FOREIGN KEY (veterinario_id) REFERENCES veterinario(id) ON DELETE CASCADE,
    CHECK (fecha >= CURRENT_DATE)
);


-- TABLA FACTURA

CREATE TABLE factura 
(
    id SERIAL PRIMARY KEY,
    importe DECIMAL(10,2) NOT NULL,
    cita_id INT UNIQUE NOT NULL,
    FOREIGN KEY (cita_id) REFERENCES cita(id) ON DELETE CASCADE,
    CHECK (importe > 0)
);



-- PRUEBAS
-- PERSONAS

INSERT INTO persona (nombre, apellido, dni)
VALUES 
('Juan', 'Perez', '11111111A'),
('Maria', 'Lopez', '22222222B'),
('Carlos', 'Gomez', '33333333C'),
( 'Cliente', 'Prueba', '00000000T'),
('Cliente', 'Prueba', '00000005T');


-- CLIENTES (Juan y Maria)

INSERT INTO cliente (id, telefono)
VALUES 
(1, '600111222'),
(2, '600333444');


-- VETERINARIO (Carlos)

INSERT INTO veterinario (id, especialidad)
VALUES 
(3, 'Cirugia');


-- ANIMALES

INSERT INTO animal (nombre, especie, raza, cliente_id)
VALUES 
('Bobby', 'Perro', 'Labrador', 1),
('Misu', 'Gato', 'Siames', 2);


-- CITAS

INSERT INTO cita (fecha, hora, cliente_id, veterinario_id)
VALUES 
(CURRENT_DATE, '10:00', 1, 3),
(CURRENT_DATE, '11:00', 2, 3);


-- FACTURAS

INSERT INTO factura (importe, cita_id)
VALUES 
(50.00, 1),
(35.50, 2);


-- PRUEBAS
SELECT * FROM cliente;
SELECT * FROM animal;
SELECT * FROM cita;
SELECT * FROM factura;



SELECT id, nombre, apellido
FROM persona
WHERE id = 4;



SELECT * FROM cliente WHERE id = 3;