package com.campus.backendproject.service.interfaz;

import com.campus.backendproject.dto.categoria.CategoriaRequest;
import com.campus.backendproject.dto.categoria.CategoriaResponse;

public interface CategoriaHerramientaService {
    CategoriaResponse buscarCategoriaPorNombre(CategoriaRequest categoriaRequest);
}
