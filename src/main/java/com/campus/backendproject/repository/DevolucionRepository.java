package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Devolucion;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.enums.EstadoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {

    Optional<Devolucion> findByReserva(Reserva reserva);

    List<Devolucion> findByReservaCliente(Cliente cliente);

    List<Devolucion> findByReservaHerramientaProveedor(Proveedor proveedor);

    List<Devolucion> findByEstadoEquipo(EstadoEquipo estadoEquipo);

    List<Devolucion> findByAceptadoPorProveedorFalse();

    List<Devolucion> findByEstadoEquipoAndAceptadoPorProveedorFalse(EstadoEquipo estadoEquipo);
}