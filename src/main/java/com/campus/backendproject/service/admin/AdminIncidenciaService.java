package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminIncidenciaResponse;
import com.campus.backendproject.enums.EstadoIncidencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminIncidenciaService {

    Page<AdminIncidenciaResponse> listarConFiltros(
            EstadoIncidencia estado,
            String search,
            Pageable pageable
    );
}
