DROP DATABASE 'prestamos';

CREATE DATABASE 'prestamos';

-- lector
CREATE TABLE 'lector' (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(12) UNIQUE NOT NULL,   
    `password` varchar(20) NOT NULL,
    `email` varchar(30) NOT NULL,
    `telefono` int,
    `direcciones` int,
    `nombre` varchar(30) NOT NULL,
    `apellidos` varchar(30) NOT NULL,
) ENGINE='InnoDB';

-- direccion
CREATE TABLE 'direcciones' (
  `id_direccion` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tipoVia` varchar(20),
  `nombreVia` varchar(30),
  `numero` int,
  `portal` varchar(100),
  `planta` int,
  `cp` varchar(20),
  `localidad` varchar(20)
) ENGINE='InnoDB';

-- libro
CREATE TABLE 'libro' (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ISBN` varchar(13) UNIQUE NOT NULL,
    `titulo` varchar(30) NOT NULL,
    `autor` varchar(30) NOT NULL,
    `edicion` int,
    `editorial` varchar(30) NOT NULL,
    `año` varchar(4) NOT NULL
) ENGINE='InnoDB';

-- operario
CREATE TABLE 'operario' (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(12) UNIQUE NOT NULL,   
    `password` varchar(20) NOT NULL,
    `email` varchar(30) NOT NULL
) ENGINE='InnoDB';