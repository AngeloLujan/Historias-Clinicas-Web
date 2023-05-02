package com.upc.historiasclinicas.negocio;
import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import com.upc.historiasclinicas.model.HistoriaClinicaMedicamentosFrecuentes;

import java.util.List;

public interface IHistoriaClinicaMedicamentosFrecuentesNegocio {
    public HistoriaClinicaMedicamentosFrecuentes create(HistoriaClinicaMedicamentosFrecuentes model);
    public List<HistoriaClinicaMedicamentosFrecuentes> getByHistoriaClinicaId(int historiaClinicaId);


}
