package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;

import java.util.List;

public interface IHistoriaClinicaAntecedentesNegocio {
    public HistoriaClinicaAntecedentes create(HistoriaClinicaAntecedentes model);
    public List<HistoriaClinicaAntecedentes> getByHistoriaClinicaId(int historiaClinicaId);
}
