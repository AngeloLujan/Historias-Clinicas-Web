package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import com.upc.historiasclinicas.model.HistoriaClinicaMedicamentosFrecuentes;
import com.upc.historiasclinicas.repository.HistoriaClinicaMedicamentosFrecuentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaMedicamentosFrecuentesNegocio implements IHistoriaClinicaMedicamentosFrecuentesNegocio{

    @Autowired
    HistoriaClinicaMedicamentosFrecuentesRepository historiaClinicaMedicamentosFrecuentesRepository;

    @Override
    public HistoriaClinicaMedicamentosFrecuentes create(HistoriaClinicaMedicamentosFrecuentes model) {
        return historiaClinicaMedicamentosFrecuentesRepository.save(model);
    }

    @Override
    public List<HistoriaClinicaMedicamentosFrecuentes> getByHistoriaClinicaId(int historiaClinicaId) {
        return historiaClinicaMedicamentosFrecuentesRepository.findByHistoriaClinicaId(historiaClinicaId);
    }
}
