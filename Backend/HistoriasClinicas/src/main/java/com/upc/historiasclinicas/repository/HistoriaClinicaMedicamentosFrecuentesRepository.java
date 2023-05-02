package com.upc.historiasclinicas.repository;

import com.upc.historiasclinicas.model.HistoriaClinicaMedicamentosFrecuentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoriaClinicaMedicamentosFrecuentesRepository extends JpaRepository<HistoriaClinicaMedicamentosFrecuentes,Integer> {
    @Query("select p from HistoriaClinicaMedicamentosFrecuentes p where p.historiaClinicaId = :historiaClinicaId")
    List<HistoriaClinicaMedicamentosFrecuentes> findByHistoriaClinicaId(@Param("historiaClinicaId") int historiaClinicaId);
}
