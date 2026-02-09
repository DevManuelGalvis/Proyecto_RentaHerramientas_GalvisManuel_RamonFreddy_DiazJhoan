package com.campus.backendproject.service.interfaz;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HerramientaService {

    Page<HerramientaResponse> listarConFiltros(
            EstadoHerramientas estado,
            Long categoriaId,
            String search,
            Pageable pageable
    );
}

