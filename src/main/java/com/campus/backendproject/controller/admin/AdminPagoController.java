package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminPagoResponse;
import com.campus.backendproject.dto.admin.AdminPagoTableResponse;
import com.campus.backendproject.enums.EstadoPago;
import com.campus.backendproject.service.admin.AdminPagoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/admin/pagos")
public class AdminPagoController {

    private final AdminPagoService service;

    public AdminPagoController(AdminPagoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<AdminPagoTableResponse> listarPagos(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) EstadoPago estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.listarPagos(search, estado, pageable);
    }

    // 💰 Totales
    @GetMapping("/totales")
    public Map<String, BigDecimal> totales() {
        return service.obtenerTotales();
    }
}
