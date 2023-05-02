package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fechaRegistro;

    private Date fechaModificacion;

    private int creadoPor;

    private int modificadoPor;

    private int pacienteId;
}
