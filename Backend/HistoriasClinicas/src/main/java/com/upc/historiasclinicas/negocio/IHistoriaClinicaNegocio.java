package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinica;
import com.upc.historiasclinicas.viewmodel.HistoriaClinicaViewModel;

public interface IHistoriaClinicaNegocio {

    public HistoriaClinica create(HistoriaClinica model);

    public HistoriaClinica registrarHistoriaClinica(HistoriaClinicaViewModel model);
}
