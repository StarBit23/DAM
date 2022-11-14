CREATE TABLE `usuario` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `username` VARCHAR(12),
    `password` VARCHAR(50),
    `email` VARCHAR(50))

CREATE TABLE `horario` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `inicio` TIME,
    `fin` TIME,
    `instalacion` INT,
    FOREIGN KEY (`instalacion`) REFERENCES `instalacion`(`id`))

CREATE TABLE `instalacion` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `nombre` VARCHAR(25),
    `descripcion` VARCHAR(120))

CREATE TABLE `reservas` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `fecha` DATE,
    `usuario` INT NOT NULL,
    `horario` INT NOT NULL,
    FOREIGN KEY `usuario` REFERENCES `usuario`(`id`),
    FOREIGN KEY `horario` REFERENCES `horario`(`id`))