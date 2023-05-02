package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;

import java.util.List;

public interface IHistoriaClinicaAlergiasNegocio {
    public HistoriaClinicaAlergias create(HistoriaClinicaAlergias model);

    public List<HistoriaClinicaAlergias> getByHistoriaClinicaId(int historiaClinicaId);
}
