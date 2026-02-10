package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminIncidenciaResponse;
import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.enums.EstadoIncidencia;
import com.campus.backendproject.repository.ReporteIncidenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminIncidenciaServiceImpl implements AdminIncidenciaService {

    private final ReporteIncidenciaRepository repository;

    public AdminIncidenciaServiceImpl(ReporteIncidenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<AdminIncidenciaResponse> listarConFiltros(
            EstadoIncidencia estado,
            String search,
            Pageable pageable
    ) {
        return repository.findAllWithFilters(estado, search, pageable)
                .map(this::mapToDto);
    }

    private AdminIncidenciaResponse mapToDto(ReporteIncidencia r) {

        AdminIncidenciaResponse dto = new AdminIncidenciaResponse();

        dto.setId(r.getId());
        dto.setDescripcion(r.getDescripcion());
        dto.setCosto(r.getCostoReparacion());
        dto.setEstado(r.getEstado().name());
        dto.setHerramienta(r.getHerramienta().getNombre());
        dto.setProveedor(r.getProveedor().getNombreEmpresa());
        dto.setFecha(r.getFechaReporte());

        return dto;
    }
}

