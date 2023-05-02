package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.MedicamentosFrecuentes;
import com.upc.historiasclinicas.negocio.IMedicamentosFrecuentesNegocio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/medicamentosFrecuentes")
@AllArgsConstructor
public class MedicamentosFrecuentesController {

    private final IMedicamentosFrecuentesNegocio medicamentosFrecuentesNegocio;

    @GetMapping
    public List<MedicamentosFrecuentes> getAll(){
        return medicamentosFrecuentesNegocio.getAll();
    }
}
