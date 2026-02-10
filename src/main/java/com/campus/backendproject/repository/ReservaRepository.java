package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.dto.admin.AdminTopHerramientaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("""
    SELECT r
    FROM Reserva r
    JOIN FETCH r.cliente c
    JOIN FETCH c.usuario u
    JOIN FETCH r.herramienta h
    JOIN FETCH h.proveedor p
    WHERE (:estado IS NULL OR r.estadoReserva = :estado)
      AND (:search IS NULL OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :search, '%')) 
           OR LOWER(h.nombre) LIKE LOWER(CONCAT('%', :search, '%')))
      AND (:fechaDesde IS NULL OR r.fechaInicio >= :fechaDesde)
      AND (:fechaHasta IS NULL OR r.fechaFin <= :fechaHasta)
""")
    Page<Reserva> findAllWithFilters(
            @Param("estado") EstadoReserva estado,
            @Param("search") String search,
            @Param("fechaDesde") LocalDateTime fechaDesde,
            @Param("fechaHasta") LocalDateTime fechaHasta,
            Pageable pageable
    );

    @Query("""
    SELECT COUNT(r) 
    FROM Reserva r 
    WHERE r.herramienta.id = :hId 
      AND r.estadoReserva IN (com.campus.backendproject.enums.EstadoReserva.RESERVADA, 
                              com.campus.backendproject.enums.EstadoReserva.EN_CURSO)
      AND (:inicio < r.fechaFin AND :fin > r.fechaInicio)
    """)
    long countReservasActivasEnRango(
            @Param("hId") Long herramientaId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    @Query("SELECT new com.campus.backendproject.dto.admin.AdminTopHerramientaResponse(r.herramienta.nombre, COUNT(r)) " +
            "FROM Reserva r " +
            "GROUP BY r.herramienta.nombre " +
            "ORDER BY COUNT(r) DESC")
    List<AdminTopHerramientaResponse> findTopHerramientas();
}
