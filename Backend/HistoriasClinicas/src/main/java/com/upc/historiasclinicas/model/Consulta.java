package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numero;

    private Date fecha;

    private String motivo;

    private String tiempoEnfermedad;

    private String diagnostico;

    private String tratamiento;

    private String observaciones;

    private Date proximaCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historiaClinicaId", referencedColumnName = "id")
    private HistoriaClinica historiaClinica;
}
