package com.campus.backendproject.controller.proveedor;

import com.campus.backendproject.dto.proveedor.ProveedorDashboardStatsResponse;
import com.campus.backendproject.dto.proveedor.TopHerramientaResponse;
import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorDashboardService;
import com.campus.backendproject.service.seguridad.interfaz.SeguridadService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor/dashboard")
public class ProveedorDashboardController {

    private final ProveedorDashboardService dashboardService;
    private final SeguridadService seguridadService;


    public ProveedorDashboardController(
            ProveedorDashboardService dashboardService, SeguridadService seguridadService) {
        this.dashboardService = dashboardService;
        this.seguridadService = seguridadService;
    }

    @GetMapping("/stats")
    public ProveedorDashboardStatsResponse obtenerEstadisticas() {

        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();

        return dashboardService.obtenerEstadisticas(proveedorId);
    }
    @GetMapping("/debug")
    public Object debug(Authentication auth) {
        return auth.getAuthorities();
    }

    @GetMapping("/reservas/recientes")
    public List<ReservaResponse> obtenerReservasRecientes(
            @RequestParam(defaultValue = "5") int limit
    ) {
        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();
        return dashboardService.obtenerReservasRecientes(proveedorId, limit);
    }

    @GetMapping("/herramientas/top")
    public List<TopHerramientaResponse> obtenerTopHerramientas(
            @RequestParam(defaultValue = "5") int limit
    ) {
        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();
        return dashboardService.obtenerTopHerramientas(proveedorId, limit);
    }



}
