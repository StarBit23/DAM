CREATE TABLE `usuario` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY,
    `username` VARCHAR(12),
    `password` VARCHAR(50),
    `email` VARCHAR(50))

CREATE TABLE `estancia` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY)

CREATE TABLE `incidencia` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY)

CREATE TABLE `inventario` (
    `id` INT NOT  NULL AUTOINCREMENT PRIMARY KEY)