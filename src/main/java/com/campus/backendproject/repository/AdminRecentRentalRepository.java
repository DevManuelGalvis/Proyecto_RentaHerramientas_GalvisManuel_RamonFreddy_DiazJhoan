package com.campus.backendproject.repository;

import com.campus.backendproject.dto.admin.AdminRecentRentalResponse;
import com.campus.backendproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRecentRentalRepository extends JpaRepository<Reserva, Long> {

    @Query("""
        SELECT new com.campus.backendproject.dto.admin.AdminRecentRentalResponse(
            r.id,
            u.nombre,
            h.nombre,
            r.fechaInicio,
            r.fechaFin,
            r.estadoReserva,
            r.total
        )
        FROM Reserva r
        JOIN r.cliente c
        JOIN c.usuario u
        JOIN r.herramienta h
        ORDER BY r.fechaInicio DESC
    """)
    List<AdminRecentRentalResponse> obtenerReservasRecientes(
            @Param("limit") int limit
    );
}
