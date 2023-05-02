package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.*;
import com.upc.historiasclinicas.repository.HistoriaClinicaAlergiasRepository;
import com.upc.historiasclinicas.repository.HistoriaClinicaAntecedentesRepository;
import com.upc.historiasclinicas.repository.HistoriaClinicaMedicamentosFrecuentesRepository;
import com.upc.historiasclinicas.repository.HistoriaClinicaRepository;
import com.upc.historiasclinicas.viewmodel.HistoriaClinicaViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoriaClinicaNegocio implements IHistoriaClinicaNegocio{

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    HistoriaClinicaAlergiasRepository historiaClinicaAlergiasRepository;

    @Autowired
    HistoriaClinicaAntecedentesRepository historiaClinicaAntecedentesRepository;

    @Autowired
    HistoriaClinicaMedicamentosFrecuentesRepository historiaClinicaMedicamentosFrecuentesRepository;

    @Override
    public HistoriaClinica create(HistoriaClinica model) {
        return historiaClinicaRepository.save(model);
    }

    @Override
    public HistoriaClinica registrarHistoriaClinica(HistoriaClinicaViewModel model) {

        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setFechaRegistro(new Date());
        historiaClinica.setCreadoPor(model.getCreadoPor());
        historiaClinica.setPacienteId(model.getPacienteId());
        historiaClinicaRepository.save(historiaClinica);

        for(Alergias item : model.getListaAlergias()){
            HistoriaClinicaAlergias historiaClinicaAlergias = new HistoriaClinicaAlergias();
            historiaClinicaAlergias.setAlegiaId(item.getId());
            historiaClinicaAlergias.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaAlergiasRepository.save(historiaClinicaAlergias);
        }

        for(Antecedentes item : model.getListaAntecedentes()){
            HistoriaClinicaAntecedentes historiaClinicaAntecedentes = new HistoriaClinicaAntecedentes();
            historiaClinicaAntecedentes.setAntecedenteId(item.getId());
            historiaClinicaAntecedentes.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaAntecedentesRepository.save(historiaClinicaAntecedentes);
        }

        for(MedicamentosFrecuentes item : model.getListaMedicamentosFrecuentes()){
            HistoriaClinicaMedicamentosFrecuentes historiaClinicaMedicamentosFrecuentes = new HistoriaClinicaMedicamentosFrecuentes();
            historiaClinicaMedicamentosFrecuentes.setMedicamentoFrecuenteId(item.getId());
            historiaClinicaMedicamentosFrecuentes.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaMedicamentosFrecuentesRepository.save(historiaClinicaMedicamentosFrecuentes);
        }

        return historiaClinica;
    }
}
