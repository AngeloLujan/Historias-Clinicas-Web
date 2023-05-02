package com.upc.historiasclinicas.repository;

import com.upc.historiasclinicas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    @Query("select p from Paciente p where p.tipoDocumento = :tipoDocumento and p.numeroDocumento like %:numeroDocumento%")
    public List<Paciente> getAllPacientesByTipoDocumentoAndNumeroDocumento(@Param("tipoDocumento") String tipoDocumento,
                                                                           @Param("numeroDocumento") String numeroDocumento);

    //@Query("select p from Paciente p where p.nombres = :nombres and p.apellidoPaterno = :apellidoPaterno and p.apellidoMaterno = :apellidoMaterno and p.tipoDocumento = :tipoDocumento and p.numeroDocumento = :numeroDocumento")
    @Query("SELECT p FROM Paciente p WHERE (:nombres = ''  or p.nombres = :nombres) AND (:apellidoPaterno = ''  or p.apellidoPaterno = :apellidoPaterno) AND (:apellidoMaterno = ''  or p.apellidoMaterno = :apellidoMaterno) AND (:tipoDocumento = ''  or p.tipoDocumento = :tipoDocumento) AND (:numeroDocumento = ''  or p.numeroDocumento = :numeroDocumento)")
    public List<Paciente> getAllPacientesFiltro(@Param("nombres") String nombres,
                                                @Param("apellidoPaterno") String apellidoPaterno,
                                                @Param("apellidoMaterno") String apellidoMaterno,
                                                @Param("tipoDocumento") String tipoDocumento,
                                                @Param("numeroDocumento") String numeroDocumento);
}
