package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.Antecedentes;
import com.upc.historiasclinicas.negocio.IAntecedentesNegocio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/antecedentes")
@AllArgsConstructor
public class AntecedentesController {

    private final IAntecedentesNegocio antecedentesNegocio;

    @GetMapping
    public List<Antecedentes> getAll(){
        return antecedentesNegocio.getAll();
    }
}
