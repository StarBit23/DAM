package com.iesvdc.gestion.modelo;

import java.sql.Time;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Horario {
    private Instalacion instalacion;
    private Time horaInicio;
    private Time horaFin;
}
