package com.campus.backendproject.repository;

import com.campus.backendproject.dto.admin.AdminPagoTableResponse;
import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.enums.EstadoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("""
    SELECT new com.campus.backendproject.dto.admin.AdminPagoTableResponse(
        p.id, 
        f.id, 
        c.usuario.nombre, 
        h.nombre, 
        p.monto, 
        p.fecha_pago, 
        r.fechaFin, 
        CAST(p.estado_pago AS string)
        )
        FROM Pago p
        JOIN p.reserva r
        JOIN r.cliente c
        JOIN r.herramienta h
        LEFT JOIN Factura f ON f.pago.id = p.id
        WHERE (:estado IS NULL OR p.estado_pago = :estado)
        AND (
            :search IS NULL OR
            LOWER(c.usuario.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        ORDER BY p.fecha_pago DESC
    """)
    Page<AdminPagoTableResponse> listarPagosAdmin(
            @Param("search") String search,
            @Param("estado") EstadoPago estado,
            Pageable pageable
    );

    // 🔹 Totales
    @Query("SELECT COALESCE(SUM(p.monto), 0) FROM Pago p WHERE p.estado_pago = :estado")
    BigDecimal totalPorEstado(@Param("estado") EstadoPago estado);
}
