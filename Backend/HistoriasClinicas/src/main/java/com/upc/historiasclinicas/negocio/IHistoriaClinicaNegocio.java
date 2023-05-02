package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface IHistoriaClinicaNegocio {

    public HistoriaClinica create(HistoriaClinica model);

    public HistoriaClinica registrarHistoriaClinica(HistoriaClinica model);

    public List<HistoriaClinica> getAllHistoriaClinica();

    public Optional<HistoriaClinica> getById(int id);
}
