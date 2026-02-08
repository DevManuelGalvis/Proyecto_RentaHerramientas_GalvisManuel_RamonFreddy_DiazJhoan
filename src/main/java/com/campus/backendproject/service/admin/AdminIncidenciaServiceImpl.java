package com.campus.backendproject.service.admin;

import com.campus.backendproject.entity.ReporteIncidencia;
import com.campus.backendproject.repository.ReporteIncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminIncidenciaServiceImpl implements AdminIncidenciaService {

    private final ReporteIncidenciaRepository repository;

    public AdminIncidenciaServiceImpl(ReporteIncidenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReporteIncidencia> listarIncidencias() {
        return repository.findAll();
    }
}
