package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Antecedentes;
import com.upc.historiasclinicas.repository.AntecedentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesNegocio implements IAntecedentesNegocio{

    @Autowired
    AntecedentesRepository antecedentesRepository;
    @Override
    public List<Antecedentes> getAll() {
        return antecedentesRepository.findAll();
    }
}
