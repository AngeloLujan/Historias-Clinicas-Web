package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.HistoriaClinica;
import com.upc.historiasclinicas.negocio.IHistoriaClinicaNegocio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class HistoriaClinicaController {

    @Autowired
    private IHistoriaClinicaNegocio historiaClinicaNegocio;

    @PostMapping("/historiaClinica")
    public HistoriaClinica registrar(@RequestBody HistoriaClinica historiaClinica){
        return historiaClinicaNegocio.registrarHistoriaClinica(historiaClinica);
    }

    @GetMapping("/historiaClinica")
    public List<HistoriaClinica> getAll(){
        return historiaClinicaNegocio.getAllHistoriaClinica();
    }

    @GetMapping("/historiaClinica/{id}")
    public Optional<HistoriaClinica> getId(@PathVariable int id){
        return historiaClinicaNegocio.getById(id);
    }
}
