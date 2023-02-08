CREATE DATABADE incidencias1 CHARACTER SET utf8 COLLATE utf8_

USE indicendias1

SET GLOBAL time_zone = '+1:00'

SET names 'utf8'


CREATE TABLE `estancia` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` varchar(25) UNIQUE NOT NULL,
    `descripcion` varchar(100) UNIQUE NOT NULL
) ENGINE='InnoDB'