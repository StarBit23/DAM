package com.iesvdc.gestion.modelo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Reserva {
    private Usuario usuario;
    private Horario horario;
    private Date fecha;
}
