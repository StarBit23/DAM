CREATE TABLE `usuario` (
    `id` INT NOT NULL AUTOINCREMENT PRIMARY KEY,
    `nombre` VARCHAR,
    `username` VARCHAR(12),
    `password` VARCHAR(50),
    `email` VARCHAR(50),
    `direccion` VARCHAR(25)
)

CREATE TABLE `operador` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `nombre` VARCHAR,
    `username` VARCHAR(12),
    `password` VARCHAR(50),
    `email` VARCHAR(50),
    `tfno` INT NOT NULL
)

CREATE TABLE `incidencias` (
    `id` INT NOT NULL AUTOINCREMENT PRIMARY KEY,
    `estado` ENUM(`RESUELTA`,`PENDIENTE`,`SIN_RESOLVER`),
    `fecha` DATE,
    `aula` VARCHAR(5),
    `equipamiento` VARCHAR(20),
    FOREIGN KEY (`usuario`) REFERENCES `usuario`(`id`),
    FOREIGN KEY (`operador`) REFERENCES `operador`(`id`)
)



