package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import com.upc.historiasclinicas.repository.HistoriaClinicaAlergiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaClinicaAlergiasNegocio implements IHistoriaClinicaAlergiasNegocio{

    @Autowired
    HistoriaClinicaAlergiasRepository historiaClinicaAlergiasRepository;

    @Override
    public HistoriaClinicaAlergias create(HistoriaClinicaAlergias model) {
        return historiaClinicaAlergiasRepository.save(model);
    }
}
