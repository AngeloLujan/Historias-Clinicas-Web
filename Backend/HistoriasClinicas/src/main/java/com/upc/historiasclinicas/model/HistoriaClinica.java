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

    private String numero;

    private Date fechaRegistro;

    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creadoPor", referencedColumnName = "id")
    private Usuario usuarioCreador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modificadoPor", referencedColumnName = "id")
    private Usuario usuarioModificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacienteId", referencedColumnName = "id")
    private Paciente paciente;
}
