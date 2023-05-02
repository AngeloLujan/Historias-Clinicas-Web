package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaAlergiasNegocio;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaAntecedentesNegocio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class HistoriaClinicaAntecedentesController {

    @Autowired
    private IHistoriaClinicaAntecedentesNegocio historiaClinicaAntecedentesNegocio;

    @GetMapping("/historiaClinicaAntecedentes/{historiaClinicaId}")
    public List<HistoriaClinicaAntecedentes> getId(@PathVariable int historiaClinicaId){
        return historiaClinicaAntecedentesNegocio.getByHistoriaClinicaId(historiaClinicaId);
    }
}
