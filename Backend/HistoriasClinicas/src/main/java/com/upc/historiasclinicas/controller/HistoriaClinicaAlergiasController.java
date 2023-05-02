package com.upc.historiasclinicas.controller;
import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaAlergiasNegocio;
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
public class HistoriaClinicaAlergiasController {


    @Autowired
    private IHistoriaClinicaAlergiasNegocio historiaClinicaAlergiasNegocio;

    @GetMapping("/historiaClinicaAlergias/{historiaClinicaId}")
    public List<HistoriaClinicaAlergias> getId(@PathVariable int historiaClinicaId){
        return historiaClinicaAlergiasNegocio.getByHistoriaClinicaId(historiaClinicaId);
    }
}
