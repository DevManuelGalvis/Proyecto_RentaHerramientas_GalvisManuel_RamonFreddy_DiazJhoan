package com.campus.backendproject.service;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;

import java.util.List;

public interface HerramientaService {

    List<HerramientaResponse> listarTodas();

    List<HerramientaResponse> disponibles();

    List<HerramientaResponse> porCategoria(Long categoriaId);

    List<HerramientaResponse> buscar(String nombre);
}

