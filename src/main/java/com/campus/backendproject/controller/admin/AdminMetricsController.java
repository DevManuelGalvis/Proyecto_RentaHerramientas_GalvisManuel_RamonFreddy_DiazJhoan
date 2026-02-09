package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminIngresoMensualResponse;
import com.campus.backendproject.dto.admin.AdminMetricsResponse;
import com.campus.backendproject.dto.admin.AdminRecentRentalResponse;
import com.campus.backendproject.dto.admin.AdminTopHerramientaResponse;
import com.campus.backendproject.service.admin.AdminMetricsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminMetricsController {

    private final AdminMetricsService service;

    public AdminMetricsController(AdminMetricsService service) {
        this.service = service;
    }

    @GetMapping("/metricas")
    public AdminMetricsResponse obtenerMetricas() {
        return service.obtenerMetricas();
    }

    @GetMapping("/reservas/recientes")
    public List<AdminRecentRentalResponse> reservasRecientes(
            @RequestParam(defaultValue = "10") int limit
    ) {
        return service.obtenerReservasRecientes(limit);
    }

    @GetMapping("/ingresos/mensuales")
    public List<AdminIngresoMensualResponse> ingresosMensuales() {
        return service.obtenerIngresosMensuales();
    }

    @GetMapping("/reservas/estadisticas")
    public Map<String, Long> estadisticasReservas() {
        return service.obtenerEstadisticasReservas();
    }

    @GetMapping("/herramientas/top")
    public List<AdminTopHerramientaResponse> obtenerTopHerramientas() {
        return service.obtenerTopHerramientas();
    }

}
