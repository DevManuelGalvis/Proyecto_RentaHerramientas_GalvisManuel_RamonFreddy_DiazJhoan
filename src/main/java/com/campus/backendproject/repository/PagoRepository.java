package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.enums.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    Optional<Pago> findByReserva(Reserva reserva);

    List<Pago> findByReservaCliente(Cliente cliente);

    List<Pago> findByReservaHerramientaProveedor(Proveedor proveedor);

    List<Pago> findByEstadoPago(EstadoPago estadoPago);

    @Query("SELECT SUM(p.monto) FROM Pago p WHERE p.estadoPago = 'COMPLETADO'")
    BigDecimal calcularIngresosTotales();

    @Query("SELECT p.reserva.herramienta.proveedor, SUM(p.monto) FROM Pago p " +
            "WHERE p.estadoPago = 'COMPLETADO' " +
            "GROUP BY p.reserva.herramienta.proveedor")
    List<Object[]> calcularIngresosPorProveedor();
}