package com.campus.backendproject.controller.admin;

import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.service.admin.AdminPagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/pagos")
public class AdminPagoController {

    private final AdminPagoService service;

    public AdminPagoController(AdminPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pago> listar() {
        return service.listarPagos();
    }
}
