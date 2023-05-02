package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import com.upc.historiasclinicas.repository.HistoriaClinicaAlergiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaAlergiasNegocio implements IHistoriaClinicaAlergiasNegocio{

    @Autowired
    HistoriaClinicaAlergiasRepository historiaClinicaAlergiasRepository;

    @Override
    public HistoriaClinicaAlergias create(HistoriaClinicaAlergias model) {
        return historiaClinicaAlergiasRepository.save(model);
    }

    @Override
    public List<HistoriaClinicaAlergias> getByHistoriaClinicaId(int historiaClinicaId) {
        return historiaClinicaAlergiasRepository.finByHistoriaClinicaId(historiaClinicaId);
    }
}
