package com.upc.historiasclinicas.controller;

import com.upc.historiasclinicas.model.Paciente;
import com.upc.historiasclinicas.negocio.IPacienteNegocio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class PacienteController {

    private final IPacienteNegocio pacienteNegocio;

    @GetMapping("/pacientesByTipoDocumentoAndNumeroDocumento")
    public List<Paciente> getAllPacientesByTipoDocumentoAndNumeroDocumento(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento){
        return pacienteNegocio.getAllPacientesByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }

    @GetMapping("/pacientesFiltro")
    public List<Paciente> getAllPacientesFiltro(@RequestParam String nombres, @RequestParam String apellidoPaterno, @RequestParam String apellidoMaterno, @RequestParam String tipoDocumento, @RequestParam String numeroDocumento){
        return pacienteNegocio.getAllPacientesFiltro(nombres,apellidoPaterno,apellidoMaterno,tipoDocumento, numeroDocumento);
    }

    @GetMapping("pacientes")
    public List<Paciente> getAll(){
        return pacienteNegocio.getAll();
    }

    @GetMapping("/paciente/{id}")
    public Optional<Paciente> getId(@PathVariable int id){
        return pacienteNegocio.getId(id);
    }

    @PostMapping("/paciente")
    public Paciente create(@RequestBody Paciente paciente){
        return pacienteNegocio.create(paciente);
    }
}
