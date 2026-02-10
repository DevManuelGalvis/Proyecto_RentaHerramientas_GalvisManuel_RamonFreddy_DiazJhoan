package com.campus.backendproject.repository;

import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.enums.EstadoIncidencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReporteIncidenciaRepository extends JpaRepository<ReporteIncidencia, Long> {

    @Query("""
        SELECT r
        FROM ReporteIncidencia r
        WHERE (:estado IS NULL OR r.estado = :estado)
          AND (
                COALESCE(:search,'') = ''
                OR LOWER(r.herramienta.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
              )
    """)
    Page<ReporteIncidencia> findAllWithFilters(
            @Param("estado") EstadoIncidencia estado,
            @Param("search") String search,
            Pageable pageable
    );
}

