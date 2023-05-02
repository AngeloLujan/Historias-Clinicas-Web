package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Paciente;
import com.upc.historiasclinicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteNegocio implements IPacienteNegocio{

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientesByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento) {

        if(tipoDocumento.equals("-1") && numeroDocumento.isEmpty()){
            return pacienteRepository.findAll();
        }else{
            return pacienteRepository.getAllPacientesByTipoDocumentoAndNumeroDocumento(tipoDocumento,numeroDocumento);
        }
    }

    @Override
    public List<Paciente> getAllPacientesFiltro(String nombres, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroDocumento) {

        if(nombres.isEmpty() && apellidoPaterno.isEmpty() && apellidoMaterno.isEmpty() && tipoDocumento.equals("-1") && numeroDocumento.isEmpty()){
            return pacienteRepository.findAll();
        }

        return  pacienteRepository.getAllPacientesFiltro(nombres, apellidoPaterno, apellidoMaterno, tipoDocumento, numeroDocumento);
    }

    @Override
    public Paciente create(Paciente model) {
        return pacienteRepository.save(model);
    }

    @Override
    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getId(int id) {
        return pacienteRepository.findById(id);
    }

}
