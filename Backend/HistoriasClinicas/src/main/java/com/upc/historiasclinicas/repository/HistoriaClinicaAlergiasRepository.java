package com.upc.historiasclinicas.repository;

import com.upc.historiasclinicas.model.HistoriaClinicaAlergias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaClinicaAlergiasRepository extends JpaRepository<HistoriaClinicaAlergias,Integer> {

    @Query("select p from HistoriaClinicaAlergias p where p.historiaClinicaId = :historiaClinicaId")
    List<HistoriaClinicaAlergias> finByHistoriaClinicaId(@Param("historiaClinicaId") int historiaClinicaId);
}
