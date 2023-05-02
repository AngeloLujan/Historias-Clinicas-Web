package com.upc.historiasclinicas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fechaRegistro;

    private Date fechaModificacion;

    private transient String usuarioCreador;

    private int creadoPor;

    private transient String usuarioModificador;

    private int modificadoPor;

    private transient String paciente;

    private transient String tipoDocumento;

    private transient String numeroDocumento;

    private int pacienteId;

    private transient List<Antecedentes> listaAntecedentes;

    private transient List<Alergias> listaAlergias;

    private transient List<MedicamentosFrecuentes> listaMedicamentosFrecuentes;
}
