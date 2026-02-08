package com.campus.backendproject.controller;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.service.HerramientaService;
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
    public List<HerramientaResponse> listar() {
        return service.listarTodas();
    }

    @GetMapping("/disponibles")
    public List<HerramientaResponse> disponibles() {
        return service.disponibles();
    }

    @GetMapping("/categoria/{id}")
    public List<HerramientaResponse> porCategoria(@PathVariable Long id) {
        return service.porCategoria(id);
    }

    @GetMapping("/buscar")
    public List<HerramientaResponse> buscar(@RequestParam String nombre) {
        return service.buscar(nombre);
    }
}
