package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaMedicamentosFrecuentes;
import com.upc.historiasclinicas.repository.HistoriaClinicaMedicamentosFrecuentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaClinicaMedicamentosFrecuentesNegocio implements IHistoriaClinicaMedicamentosFrecuentesNegocio{

    @Autowired
    HistoriaClinicaMedicamentosFrecuentesRepository historiaClinicaMedicamentosFrecuentesRepository;

    @Override
    public HistoriaClinicaMedicamentosFrecuentes create(HistoriaClinicaMedicamentosFrecuentes model) {
        return historiaClinicaMedicamentosFrecuentesRepository.save(model);
    }
}
