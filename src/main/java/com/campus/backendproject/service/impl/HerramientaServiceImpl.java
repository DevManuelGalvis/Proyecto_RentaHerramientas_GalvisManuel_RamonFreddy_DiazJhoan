package com.campus.backendproject.service.impl;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.service.HerramientaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository repository;

    public HerramientaServiceImpl(HerramientaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HerramientaResponse> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> disponibles() {
        return repository.findByEstado(EstadoHerramientas.DISPONIBLE)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> porCategoria(Long categoriaId) {
        return repository.findByCategoriaHerramienta_Id(categoriaId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> buscar(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::mapToDto)
                .toList();
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
                nombreCategoria,
                nombreProveedor,
                urlImagen
        );
    }
}

