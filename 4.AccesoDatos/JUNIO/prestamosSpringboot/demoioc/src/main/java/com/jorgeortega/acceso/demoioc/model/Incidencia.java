package com.jorgeortega.acceso.demoioc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String asunto;
    String descripcion;
    @ManyToOne
    Usuario usuario;
    @ManyToOne
    Usuario operario;
    String estado;
}
