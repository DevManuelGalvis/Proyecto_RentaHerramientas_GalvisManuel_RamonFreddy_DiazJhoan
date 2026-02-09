package com.campus.backendproject.repository;

import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteIncidenciaRepository extends JpaRepository<ReporteIncidencia, Long> {
}
