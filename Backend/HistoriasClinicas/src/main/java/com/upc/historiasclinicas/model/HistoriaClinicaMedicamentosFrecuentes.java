package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HistoriaClinicaMedicamentosFrecuentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historiaClinicaId", referencedColumnName = "id")
    private HistoriaClinica historiaClinica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamentoFrecuenteId", referencedColumnName = "id")
    private MedicamentosFrecuentes medicamentoFrecuente;
}
