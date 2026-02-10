package com.campus.backendproject.controller;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.service.interfaz.HerramientaService;
import com.campus.backendproject.service.impl.HerramientaServiceImpl;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    private final HerramientaService service;

    public HerramientaController(HerramientaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<HerramientaResponse> listar(
            @RequestParam(required = false) EstadoHerramientas estado,
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false, defaultValue = "") String search,
            @ParameterObject Pageable pageable
    ) {
        return service.listarConFiltros(estado, categoriaId, search, pageable);
    }
}

