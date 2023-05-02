package com.upc.historiasclinicas.repository;

import com.upc.historiasclinicas.model.HistoriaClinicaAntecedentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaClinicaAntecedentesRepository extends JpaRepository<HistoriaClinicaAntecedentes,Integer> {
    @Query("select p from HistoriaClinicaAntecedentes p where p.historiaClinicaId = :historiaClinicaId")
    List<HistoriaClinicaAntecedentes> findByHistoriaClinicaId(@Param("historiaClinicaId") int historiaClinicaId);
}
