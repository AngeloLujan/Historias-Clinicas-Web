package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import com.upc.historiasclinicas.repository.HistoriaClinicaAntecedentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaAntecedentesNegocio implements IHistoriaClinicaAntecedentesNegocio{

    @Autowired
    HistoriaClinicaAntecedentesRepository historiaClinicaAntecedentesRepository;

    @Override
    public HistoriaClinicaAntecedentes create(HistoriaClinicaAntecedentes model) {
        return historiaClinicaAntecedentesRepository.save(model);
    }

    @Override
    public List<HistoriaClinicaAntecedentes> getByHistoriaClinicaId(int historiaClinicaId) {
        return historiaClinicaAntecedentesRepository.findByHistoriaClinicaId(historiaClinicaId);
    }
}
