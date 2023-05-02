package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.MedicamentosFrecuentes;
import com.upc.historiasclinicas.repository.MedicamentosFrecuentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentosFrecuentesNegocio implements  IMedicamentosFrecuentesNegocio{

    @Autowired
    MedicamentosFrecuentesRepository medicamentosFrecuentesRepository;
    @Override
    public List<MedicamentosFrecuentes> getAll() {
        return medicamentosFrecuentesRepository.findAll();
    }
}
