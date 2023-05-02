package com.upc.historiasclinicas.viewmodel;

import com.upc.historiasclinicas.model.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class HistoriaClinicaViewModel
{

    private int creadoPor;

    private int modificadoPor;

    private int pacienteId;

    List<Antecedentes> listaAntecedentes;
    List<Alergias> listaAlergias;
    List<MedicamentosFrecuentes> listaMedicamentosFrecuentes;

}
