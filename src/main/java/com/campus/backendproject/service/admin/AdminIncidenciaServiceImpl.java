package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminIncidenciaResponse;
import com.campus.backendproject.repository.ReporteIncidenciaRepository;
import com.campus.backendproject.service.admin.AdminIncidenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminIncidenciaServiceImpl implements AdminIncidenciaService {

    private final ReporteIncidenciaRepository repo;

    public AdminIncidenciaServiceImpl(ReporteIncidenciaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<AdminIncidenciaResponse> listarIncidencias() {
        return repo.findAll().stream().map(i -> {
            AdminIncidenciaResponse dto = new AdminIncidenciaResponse();
            dto.setId(i.getId());
            dto.setDescripcion(i.getDescripcion());
            dto.setCosto(i.getCostoReparacion());
            dto.setEstado(i.getEstado().name());
            dto.setFecha(i.getFechaReporte());
            dto.setHerramienta(i.getHerramienta().getNombre());
            dto.setProveedor(i.getProveedor().getNombreEmpresa());
            return dto;
        }).toList();
    }
}
