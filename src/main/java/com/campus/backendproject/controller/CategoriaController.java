package com.campus.backendproject.controller;

import com.campus.backendproject.dto.categoria.CategoriaRequest;
import com.campus.backendproject.dto.categoria.CategoriaResponse;
import com.campus.backendproject.service.interfaz.CategoriaHerramientaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaHerramientaService service;

    public CategoriaController(CategoriaHerramientaService service) {
        this.service = service;
    }
    
    @PostMapping("/buscar-nombre")
    public ResponseEntity<CategoriaResponse> buscarPorNombre(@RequestBody CategoriaRequest request) {
        CategoriaResponse response = service.buscarCategoriaPorNombre(request);
        return ResponseEntity.ok(response);
    }
}
