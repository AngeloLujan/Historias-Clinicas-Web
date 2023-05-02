package com.upc.historiasclinicas.repository;

import com.upc.historiasclinicas.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica,Integer> {
}
