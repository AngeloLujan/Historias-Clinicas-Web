package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import com.upc.historiasclinicas.model.HistoriaClinicaMedicamentosFrecuentes;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaAntecedentesNegocio;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaMedicamentosFrecuentesNegocio;
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
public class HistoriaClinicaMedicamentosFrecuentesController {

    @Autowired
    private IHistoriaClinicaMedicamentosFrecuentesNegocio historiaClinicaMedicamentosFrecuentesNegocio;

    @GetMapping("/historiaClinicaMedicamentosFrecuentes/{historiaClinicaId}")
    public List<HistoriaClinicaMedicamentosFrecuentes> getId(@PathVariable int historiaClinicaId){
        return historiaClinicaMedicamentosFrecuentesNegocio.getByHistoriaClinicaId(historiaClinicaId);
    }
}
