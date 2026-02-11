package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByCliente(Cliente cliente);

    List<Reserva> findByHerramientaProveedor(Proveedor proveedor);

    List<Reserva> findByEstado(EstadoReserva estado);

    @Query("SELECT r FROM Reserva r WHERE r.herramienta.id = :herramientaId " +
            "AND r.estado IN ('CONFIRMADA', 'EN_CURSO') " +
            "AND ((r.fechaInicio <= :fechaFin AND r.fechaFin >= :fechaInicio))")
    List<Reserva> findReservasActivasByHerramientaAndFechas(
            @Param("herramientaId") Long herramientaId,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin
    );

    @Query("SELECT r.cliente, COUNT(r) FROM Reserva r GROUP BY r.cliente ORDER BY COUNT(r) DESC")
    List<Object[]> findClientesFrecuentes();

    @Query("SELECT r.herramienta, COUNT(r) FROM Reserva r GROUP BY r.herramienta ORDER BY COUNT(r) DESC")
    List<Object[]> findHerramientasMasAlquiladas();
}