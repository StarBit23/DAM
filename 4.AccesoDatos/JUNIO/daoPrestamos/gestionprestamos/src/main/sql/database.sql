DROP DATABASE IF EXISTS prestamos;

CREATE DATABASE prestamos;

-- lector
CREATE TABLE lector (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(12) UNIQUE NOT NULL,   
    password VARCHAR(20) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `telefono` INT,
    `direcciones` INT,
    `nombre` VARCHAR(30) NOT NULL,
    `apellidos` VARCHAR(30) NOT NULL
) ENGINE=InnoDB;

-- direccion
CREATE TABLE direcciones (
  `id_direccion` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tipoVia` VARCHAR(20),
  `nombreVia` VARCHAR(30),
  `numero` INT,
  `portal` VARCHAR(100),
  `planta` INT,
  `cp` VARCHAR(20),
  `localidad` VARCHAR(20)
) ENGINE=InnoDB;

-- libro
CREATE TABLE libro (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ISBN` VARCHAR(13) UNIQUE NOT NULL,
    `titulo` VARCHAR(30) NOT NULL,
    `autor` VARCHAR(30) NOT NULL,
    `edicion` INT,
    `editorial` VARCHAR(30) NOT NULL,
    `año` VARCHAR(4) NOT NULL
) ENGINE=InnoDB;

-- operario
CREATE TABLE operario (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(12) UNIQUE NOT NULL,   
    `password` VARCHAR(20) NOT NULL,
    `email` VARCHAR(30) NOT NULL
) ENGINE=InnoDB;

-- prestamo
CREATE TABLE prestamo (
    lector INT,
    libro INT,
    operario INT,
    FOREIGN KEY (lector) REFERENCES lector(id),
    FOREIGN KEY (libro) REFERENCES libro(id),
    FOREIGN KEY (operario) REFERENCES operario(id)
) ENGINE=InnoDB;
