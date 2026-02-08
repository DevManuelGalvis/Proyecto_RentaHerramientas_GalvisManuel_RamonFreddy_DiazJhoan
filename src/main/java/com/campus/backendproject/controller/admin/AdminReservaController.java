package com.campus.backendproject.controller.admin;

import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.service.admin.AdminReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/reservas")
public class AdminReservaController {

    private final AdminReservaService service;

    public AdminReservaController(AdminReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listarReservas();
    }
}
