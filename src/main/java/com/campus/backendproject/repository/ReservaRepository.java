package com.campus.backendproject.repository;

import com.campus.backendproject.dto.proveedor.TopHerramientaResponse;
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
      AND r.estadoReserva IN (
            com.campus.backendproject.enums.EstadoReserva.RESERVADA,
            com.campus.backendproject.enums.EstadoReserva.EN_CURSO
      )
      AND (:inicio < r.fechaFin AND :fin > r.fechaInicio)
    """)
    long countReservasActivasEnRango(
            @Param("hId") Long herramientaId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );

    // 👉 Top herramientas global (admin)
    @Query("""
    SELECT new com.campus.backendproject.dto.admin.AdminTopHerramientaResponse(
        r.herramienta.nombre, COUNT(r)
    )
    FROM Reserva r
    GROUP BY r.herramienta.nombre
    ORDER BY COUNT(r) DESC
    """)
    List<AdminTopHerramientaResponse> findTopHerramientas();

    // 👉 Reservas por proveedor
    @Query("""
    SELECT r
    FROM Reserva r
    JOIN r.cliente c
    JOIN r.herramienta h
    WHERE h.proveedor.id = :proveedorId
      AND (:estado IS NULL OR r.estadoReserva = :estado)
    ORDER BY r.fechaInicio DESC
    """)
    Page<Reserva> findByProveedorAndEstado(
            @Param("proveedorId") Long proveedorId,
            @Param("estado") EstadoReserva estado,
            Pageable pageable
    );

    @Query("""
    SELECT COUNT(r)
    FROM Reserva r
    WHERE r.herramienta.proveedor.id = :proveedorId
      AND r.estadoReserva = :estado
    """)
    long countByProveedorAndEstado(
            @Param("proveedorId") Long proveedorId,
            @Param("estado") EstadoReserva estado
    );

    // 👉 Recientes del proveedor
    @Query("""
    SELECT r
    FROM Reserva r
    WHERE r.herramienta.proveedor.id = :proveedorId
    ORDER BY r.fechaInicio DESC
    """)
    Page<Reserva> findByProveedorRecientes(
            @Param("proveedorId") Long proveedorId,
            Pageable pageable
    );

    // 👉 Top herramientas SOLO del proveedor (para dashboard)
    @Query("""
    SELECT new com.campus.backendproject.dto.proveedor.TopHerramientaResponse(
        r.herramienta.nombre,
        COUNT(r)
    )
    FROM Reserva r
    WHERE r.herramienta.proveedor.id = :proveedorId
    GROUP BY r.herramienta.nombre
    ORDER BY COUNT(r) DESC
    """)
    Page<TopHerramientaResponse> findTopHerramientasProveedor(
            @Param("proveedorId") Long proveedorId,
            Pageable pageable
    );

    @Query("""
SELECT r
FROM Reserva r
WHERE r.herramienta.proveedor.id = :proveedorId
AND (:estado IS NULL OR r.estadoReserva = :estado)
AND (:fecha IS NULL OR DATE(r.fechaInicio) = :fecha)
ORDER BY r.fechaInicio DESC
""")
    Page<Reserva> findReservasProveedorFiltradas(
            @Param("proveedorId") Long proveedorId,
            @Param("estado") EstadoReserva estado,
            @Param("fecha") LocalDate fecha,
            Pageable pageable
    );

}
