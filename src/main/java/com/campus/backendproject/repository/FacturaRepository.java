package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Factura;
import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Optional<Factura> findByPago(Pago pago);

    Optional<Factura> findByNumeroFactura(String numeroFactura);

    List<Factura> findByPagoReservaHerramientaProveedor(Proveedor proveedor);
}