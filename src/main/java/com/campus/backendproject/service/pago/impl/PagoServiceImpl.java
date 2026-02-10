package com.campus.backendproject.service.pago.impl;

import com.campus.backendproject.dto.pago.PagoRequest;
import com.campus.backendproject.dto.pago.PagoResponse;
import com.campus.backendproject.entity.Factura;
import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.enums.EstadoPago;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.exception.BusinessRuleException;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.FacturaRepository;
import com.campus.backendproject.repository.PagoRepository;
import com.campus.backendproject.repository.ReservaRepository;
import com.campus.backendproject.service.pago.interfaz.PagoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;
    private final FacturaRepository facturaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository,
                           ReservaRepository reservaRepository,
                           FacturaRepository facturaRepository) {
        this.pagoRepository = pagoRepository;
        this.reservaRepository = reservaRepository;
        this.facturaRepository = facturaRepository;
    }

    @Override
    @Transactional()
    public PagoResponse obtenerPorId(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("Pago no encontrado con ID: " + id));

        String numFactura = (pago.getFacturas() != null) ? pago.getFacturas().getNumeroFactura() : "N/A";

        return mapToResponse(pago, numFactura);
    }

    @Override
    @Transactional
    public PagoResponse procesarPago(PagoRequest request) {

        Reserva reserva = reservaRepository.findById(request.getReservaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No se puede pagar una reserva inexistente"));

        if (reserva.getPagos() != null) {
            throw new BusinessRuleException("Esta reserva ya tiene un pago registrado");
        }

        if (request.getMonto().compareTo(reserva.getTotal()) != 0) {
            throw new BusinessRuleException("El monto enviado no coincide con el total de la reserva: " + reserva.getTotal());
        }

        Pago pago = new Pago();
        pago.setMonto(request.getMonto());
        pago.setMetodo_pago(request.getMetodoPago());
        pago.setEstado_pago(EstadoPago.PAGADO);
        pago.setFecha_pago(LocalDateTime.now());
        pago.setReserva(reserva);

        Pago pagoGuardado = pagoRepository.save(pago);

        Factura factura = new Factura();
        factura.setNumeroFactura("FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        factura.setFechaEmision(LocalDateTime.now());
        factura.setTotal(pagoGuardado.getMonto());
        factura.setPagos(pagoGuardado);

        facturaRepository.save(factura);

        reserva.setEstadoReserva(EstadoReserva.RESERVADA);

        return mapToResponse(pagoGuardado, factura.getNumeroFactura());
    }

    private PagoResponse mapToResponse(Pago p, String numeroFactura) {
        return new PagoResponse(
                p.getId(),
                p.getMonto(),
                p.getMetodo_pago(),
                p.getEstado_pago(),
                p.getFecha_pago(),
                p.getReserva().getId(),
                numeroFactura
        );
    }
}
