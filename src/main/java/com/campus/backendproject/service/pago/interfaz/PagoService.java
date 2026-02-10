package com.campus.backendproject.service.pago.interfaz;

import com.campus.backendproject.dto.pago.PagoRequest;
import com.campus.backendproject.dto.pago.PagoResponse;

public interface PagoService {
    PagoResponse procesarPago(PagoRequest request);
    PagoResponse obtenerPorId(Long id);
}
