CREATE DATABADE barajas1 CHARACTER SET utf8 COLLATE utf8_

USE barajas1

SET names 'utf8'

CREATE TABLE `palo` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` varchar(25) UNIQUE NOT NULL,
    `email` varchar(25) UNIQUE NOT NULL
) ENGINE='InnoDB'

CREATE TABLE `carta` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` varchar(25) UNIQUE NOT NULL,
    `descripcion` varchar(100) UNIQUE NOT NULL,
    `palo` varchar(20) NOT NULL
) ENGINE='InnoDB'