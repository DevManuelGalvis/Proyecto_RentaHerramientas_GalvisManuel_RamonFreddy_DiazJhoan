package com.campus.backendproject.service.factura.impl;

import com.campus.backendproject.dto.factura.FacturaResponse;
import com.campus.backendproject.entity.Factura;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.FacturaRepository;
import com.campus.backendproject.service.factura.interfaz.FacturaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    @Transactional()
    public FacturaResponse obtenerPorNumero(String numeroFactura) {
        Factura f = facturaRepository.findByNumeroFactura(numeroFactura)
                .orElseThrow(() -> new RegistroNoEncontradoException("No se encontro la factura con el numero: " + numeroFactura));

        return mapToResponse(f);
    }

    private FacturaResponse mapToResponse(Factura f) {
        return new FacturaResponse(
                f.getId(),
                f.getNumeroFactura(),
                f.getFechaEmision(),
                f.getTotal(),
                f.getPagos().getId(),
                f.getPagos().getReserva().getId(),
                f.getPagos().getReserva().getCliente().getUsuario().getNombre()
        );
    }
}
