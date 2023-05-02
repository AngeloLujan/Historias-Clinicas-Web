package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HistoriaClinicaAntecedentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int historiaClinicaId;

    private int antecedenteId;
}
