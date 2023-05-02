package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.HistoriaClinica;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaNegocio;
import com.upc.historiasclinicas.viewmodel.HistoriaClinicaViewModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class HistoriaClinicaController {

    @Autowired
    private IHistoriaClinicaNegocio historiaClinicaNegocio;

    @PostMapping("/historiaClinica")
    public HistoriaClinica registrar(@RequestBody HistoriaClinicaViewModel historiaClinica){
        return historiaClinicaNegocio.registrarHistoriaClinica(historiaClinica);
    }
}
