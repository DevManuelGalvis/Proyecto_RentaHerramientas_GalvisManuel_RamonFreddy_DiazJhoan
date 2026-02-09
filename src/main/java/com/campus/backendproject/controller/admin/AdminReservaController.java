package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.service.admin.AdminReservaService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/reservas")
public class AdminReservaController {

    private final AdminReservaService service;

    public AdminReservaController(AdminReservaService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> listar(
            @RequestParam(required = false) EstadoReserva estado,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String fechaDesde,
            @RequestParam(required = false) String fechaHasta,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        LocalDate desde = null;
        LocalDate hasta = null;

        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            desde = LocalDate.parse(fechaDesde);
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            hasta = LocalDate.parse(fechaHasta);
        }

        Page<AdminReservaResponse> reservasPage = service.listarReservas(estado, search, desde, hasta, page, size);

        Map<String, Object> response = new HashMap<>();
        response.put("content", reservasPage.getContent());
        response.put("totalElements", reservasPage.getTotalElements());
        response.put("totalPages", reservasPage.getTotalPages());
        response.put("page", reservasPage.getNumber());
        response.put("size", reservasPage.getSize());

        return response;
    }
}

