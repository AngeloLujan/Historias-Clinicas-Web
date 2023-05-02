package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.Alergias;
import com.upc.historiasclinicas.negocio.IAlergiasNegocio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/alergias")
@AllArgsConstructor
public class AlergiasController {

    private final IAlergiasNegocio alergiasNegocio;

    @GetMapping
    public List<Alergias> getAll(){
        return alergiasNegocio.getAll();
    }
}
