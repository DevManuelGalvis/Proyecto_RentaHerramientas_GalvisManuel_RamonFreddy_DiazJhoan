package com.campus.backendproject.service.impl;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.service.interfaz.HerramientaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository repository;

    public HerramientaServiceImpl(HerramientaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<HerramientaResponse> listarConFiltros(
            EstadoHerramientas estado,
            Long categoriaId,
            String search,
            Pageable pageable
    ) {
        return repository.findAllWithFilters(estado, categoriaId, search, pageable)
                .map(this::mapToDto);
    }

    private HerramientaResponse mapToDto(Herramienta h) {

        String nombreCategoria = h.getCategoriaHerramienta().getNombre();

        String nombreProveedor = h.getProveedor() != null
                ? h.getProveedor().getNombreEmpresa()
                : null;

        String urlImagen = h.getImagenesHerramientas() != null
                ? h.getImagenesHerramientas().getUrlImagen()
                : null;

        return new HerramientaResponse(
                h.getId(),
                h.getNombre(),
                h.getDescripcion(),
                h.getPrecio(),
                h.getEstado(),
                h.getStock(),
                nombreCategoria,
                nombreProveedor,
                urlImagen
        );
    }
}
