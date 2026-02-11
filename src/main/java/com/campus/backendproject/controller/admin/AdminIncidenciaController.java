package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminIncidenciaResponse;
import com.campus.backendproject.enums.EstadoIncidencia;
import com.campus.backendproject.service.admin.AdminIncidenciaService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/incidencias")
public class AdminIncidenciaController {

    private final AdminIncidenciaService service;

    public AdminIncidenciaController(AdminIncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<AdminIncidenciaResponse> listar(
            @RequestParam(required = false) EstadoIncidencia estado,
            @RequestParam(required = false, defaultValue = "") String search,
            @ParameterObject  Pageable pageable
    ) {
        return service.listarConFiltros(estado, search, pageable);
    }
}

