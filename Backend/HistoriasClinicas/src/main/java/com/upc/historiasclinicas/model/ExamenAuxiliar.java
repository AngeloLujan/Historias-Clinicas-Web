package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ExamenAuxiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private int consultaId;

    private String estado;

    private Date fechaCreacion;

    private String resultados;

    private Date fechaActualizacion;
}
