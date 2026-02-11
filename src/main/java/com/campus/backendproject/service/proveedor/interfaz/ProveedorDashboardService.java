package com.campus.backendproject.service.proveedor.interfaz;

import com.campus.backendproject.dto.proveedor.ProveedorDashboardStatsResponse;
import com.campus.backendproject.dto.proveedor.TopHerramientaResponse;
import com.campus.backendproject.dto.reserva.ReservaResponse;

import java.util.List;

public interface ProveedorDashboardService {

    ProveedorDashboardStatsResponse obtenerEstadisticas(Long proveedorId);

    List<ReservaResponse> obtenerReservasRecientes(Long proveedorId, int limit);

    List<TopHerramientaResponse> obtenerTopHerramientas(Long proveedorId, int limit);
}
