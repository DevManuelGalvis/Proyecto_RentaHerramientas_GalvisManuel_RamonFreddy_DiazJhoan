package com.campus.backendproject.repository;

import com.campus.backendproject.dto.admin.AdminIngresoMensualResponse;
import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.enums.EstadoIncidencia;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminMetricsRepository extends JpaRepository<Pago, Long> {

    @Query("SELECT COALESCE(SUM(p.monto),0) FROM Pago p")
    Long totalIngresos();

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.estadoReserva = :estado")
    Long contarPorEstado(@Param("estado") EstadoReserva estado);

    @Query("SELECT COUNT(u) FROM Usuario u")
    Long totalUsuarios();

    @Query("SELECT COUNT(h) FROM Herramienta h")
    Long totalHerramientas();

    @Query("""
        SELECT COUNT(r)
        FROM ReporteIncidencia r
        WHERE r.estado = :estado
    """)
    Long contarIncidenciasPorEstado(@Param("estado") EstadoIncidencia estado);

    @Query(value = """
        SELECT YEAR(p.fecha_pago) AS anio,
               MONTH(p.fecha_pago) AS mes,
               SUM(p.monto) AS total
        FROM pagos p
        GROUP BY YEAR(p.fecha_pago), MONTH(p.fecha_pago)
        ORDER BY anio ASC, mes ASC
    """, nativeQuery = true)
    List<Object[]> ingresosPorMes();

    @Query("""
        SELECT r.estadoReserva, COUNT(r)
        FROM Reserva r
        GROUP BY r.estadoReserva
    """)
    List<Object[]> obtenerReservasPorEstado();

}
