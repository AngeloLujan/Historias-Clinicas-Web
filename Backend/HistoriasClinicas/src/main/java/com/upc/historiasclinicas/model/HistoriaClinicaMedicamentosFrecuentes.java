package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HistoriaClinicaMedicamentosFrecuentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int historiaClinicaId;

    private int medicamentoFrecuenteId;
}
