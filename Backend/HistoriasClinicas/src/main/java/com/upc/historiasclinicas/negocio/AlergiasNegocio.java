package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Alergias;
import com.upc.historiasclinicas.repository.AlergiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiasNegocio implements  IAlergiasNegocio{

    @Autowired
    AlergiasRepository alergiasRepository;

    @Override
    public List<Alergias> getAll() {
        return alergiasRepository.findAll();
    }
}
