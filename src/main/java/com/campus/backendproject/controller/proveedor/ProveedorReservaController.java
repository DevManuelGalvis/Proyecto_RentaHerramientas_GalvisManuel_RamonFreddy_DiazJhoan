package com.campus.backendproject.controller.proveedor;

import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorReservaService;
import com.campus.backendproject.service.seguridad.interfaz.SeguridadService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/proveedor/reservas")
public class ProveedorReservaController {

    private final ProveedorReservaService reservaService;
    private final SeguridadService seguridadService;

    public ProveedorReservaController(
            ProveedorReservaService reservaService,
            SeguridadService seguridadService) {
        this.reservaService = reservaService;
        this.seguridadService = seguridadService;
    }

    // 📋 Listado con filtros
    @GetMapping
    public Page<ReservaResponse> obtenerReservasProveedor(
            @RequestParam(required = false) EstadoReserva estado,
            @RequestParam(required = false) LocalDate fecha,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();

        return reservaService.listarReservasProveedor(
                proveedorId,
                estado,
                fecha,
                page,
                size
        );
    }

    // ✅ Aprobar
    @PatchMapping("/{id}/aprobar")
    public void aprobarReserva(@PathVariable Long id) {
        reservaService.aprobarReserva(id);
    }

    // ❌ Rechazar
    @PatchMapping("/{id}/rechazar")
    public void rechazarReserva(
            @PathVariable Long id,
            @RequestBody Map<String, String> body
    ) {
        reservaService.rechazarReserva(id, body.get("motivo"));
    }
}
