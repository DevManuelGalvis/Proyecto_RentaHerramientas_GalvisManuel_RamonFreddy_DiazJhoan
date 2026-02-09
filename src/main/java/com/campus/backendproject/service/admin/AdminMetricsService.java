package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminIngresoMensualResponse;
import com.campus.backendproject.dto.admin.AdminMetricsResponse;
import com.campus.backendproject.dto.admin.AdminRecentRentalResponse;
import com.campus.backendproject.dto.admin.AdminTopHerramientaResponse;

import java.util.List;
import java.util.Map;

public interface AdminMetricsService {

    AdminMetricsResponse obtenerMetricas();

    List<AdminRecentRentalResponse> obtenerReservasRecientes(int limit);

    Map<String, Long> obtenerEstadisticasReservas();

    List<AdminIngresoMensualResponse> obtenerIngresosMensuales();

    List<AdminTopHerramientaResponse> obtenerTopHerramientas();
}
