package com.campus.backendproject.controller.admin;

import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.service.admin.AdminIncidenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/incidencias")
public class AdminIncidenciaController {

    private final AdminIncidenciaService service;

    public AdminIncidenciaController(AdminIncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReporteIncidencia> listar() {
        return service.listarIncidencias();
    }
}
