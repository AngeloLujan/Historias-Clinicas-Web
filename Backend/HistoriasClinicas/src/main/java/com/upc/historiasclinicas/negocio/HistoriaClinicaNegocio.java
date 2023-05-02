package com.upc.historiasclinicas.negocio;

import com.upc.historiasclinicas.model.*;
import com.upc.historiasclinicas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaNegocio implements IHistoriaClinicaNegocio{

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    HistoriaClinicaAlergiasRepository historiaClinicaAlergiasRepository;

    @Autowired
    HistoriaClinicaAntecedentesRepository historiaClinicaAntecedentesRepository;

    @Autowired
    HistoriaClinicaMedicamentosFrecuentesRepository historiaClinicaMedicamentosFrecuentesRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public HistoriaClinica create(HistoriaClinica model) {
        return historiaClinicaRepository.save(model);
    }

    @Override
    public HistoriaClinica registrarHistoriaClinica(HistoriaClinica model) {

        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setFechaRegistro(new Date());
        historiaClinica.setCreadoPor(model.getCreadoPor());
        historiaClinica.setPacienteId(model.getPacienteId());
        historiaClinicaRepository.save(historiaClinica);

        for(Alergias item : model.getListaAlergias()){
            HistoriaClinicaAlergias historiaClinicaAlergias = new HistoriaClinicaAlergias();
            historiaClinicaAlergias.setAlegiaId(item.getId());
            historiaClinicaAlergias.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaAlergiasRepository.save(historiaClinicaAlergias);
        }

        for(Antecedentes item : model.getListaAntecedentes()){
            HistoriaClinicaAntecedentes historiaClinicaAntecedentes = new HistoriaClinicaAntecedentes();
            historiaClinicaAntecedentes.setAntecedenteId(item.getId());
            historiaClinicaAntecedentes.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaAntecedentesRepository.save(historiaClinicaAntecedentes);
        }

        for(MedicamentosFrecuentes item : model.getListaMedicamentosFrecuentes()){
            HistoriaClinicaMedicamentosFrecuentes historiaClinicaMedicamentosFrecuentes = new HistoriaClinicaMedicamentosFrecuentes();
            historiaClinicaMedicamentosFrecuentes.setMedicamentoFrecuenteId(item.getId());
            historiaClinicaMedicamentosFrecuentes.setHistoriaClinicaId(historiaClinica.getId());
            historiaClinicaMedicamentosFrecuentesRepository.save(historiaClinicaMedicamentosFrecuentes);
        }

        return historiaClinica;
    }

    @Override
    public List<HistoriaClinica> getAllHistoriaClinica() {
        List<HistoriaClinica> listaHistoriasClinicas = historiaClinicaRepository.findAll();

        for(HistoriaClinica historiaClinica :listaHistoriasClinicas){
            Optional<Usuario> usuarioCreador = Optional.of(usuarioRepository.getById(historiaClinica.getCreadoPor()));
            if(historiaClinica.getModificadoPor() != 0){
                Optional<Usuario> usuarioModificador = Optional.of(usuarioRepository.getById(historiaClinica.getModificadoPor()));
                historiaClinica.setUsuarioModificador(usuarioModificador.get().getNombres() + " " + usuarioModificador.get().getApellidoPaterno() + " " + usuarioModificador.get().getApellidoMaterno() + " " );
            }

            Optional<Paciente> paciente = Optional.of(pacienteRepository.getById(historiaClinica.getPacienteId()));
            historiaClinica.setUsuarioCreador(usuarioCreador.get().getNombres() + " " + usuarioCreador.get().getApellidoPaterno() + " " + usuarioCreador.get().getApellidoMaterno() + " " );
            historiaClinica.setTipoDocumento(paciente.get().getTipoDocumento());
            historiaClinica.setNumeroDocumento(paciente.get().getNumeroDocumento());
            historiaClinica.setPaciente(paciente.get().getNombres() + " " + paciente.get().getApellidoPaterno() + " " + paciente.get().getApellidoMaterno() + " " );
        }

        return listaHistoriasClinicas;
    }

    @Override
    public Optional<HistoriaClinica> getById(int id) {
        return  historiaClinicaRepository.findById(id);
    }
}
