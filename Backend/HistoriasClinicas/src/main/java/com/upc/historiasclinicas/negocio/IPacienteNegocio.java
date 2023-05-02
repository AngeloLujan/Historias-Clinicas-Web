package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteNegocio {

    public List<Paciente> getAllPacientesByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);

    public List<Paciente> getAllPacientesFiltro(String nombres, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numeroDocumento);

    public Paciente create(Paciente model);

    public List<Paciente> getAll();

    public Optional<Paciente> getId(int id);
}
