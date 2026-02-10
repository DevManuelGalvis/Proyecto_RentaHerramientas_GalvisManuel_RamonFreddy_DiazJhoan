package com.campus.backendproject.service.factura.interfaz;

import com.campus.backendproject.dto.factura.FacturaResponse;

public interface FacturaService {
    FacturaResponse obtenerPorNumero(String numeroFactura);
}
