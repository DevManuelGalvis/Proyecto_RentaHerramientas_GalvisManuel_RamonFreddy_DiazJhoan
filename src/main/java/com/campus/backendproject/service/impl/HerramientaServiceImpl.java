package com.campus.backendproject.service.impl;

import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.exception.ResourceNotAvailableException;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.service.interfaz.HerramientaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository repository;

    public HerramientaServiceImpl(HerramientaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HerramientaResponse> listarTodas() {
        List<Herramienta> herramientas = repository.findAll();

        if (herramientas.isEmpty()) {
            throw new ResourceNotAvailableException("No se encontro la herramienta en la base de datos");
        }

        return herramientas.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> disponibles() {
        List<Herramienta> herramientas = repository.findByEstado(EstadoHerramientas.DISPONIBLE);

        if (herramientas.isEmpty()) {
            throw new ResourceNotAvailableException("No se encontro la herramienta en la base de datos");
        }

        return herramientas.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> porCategoria(Long categoriaId) {
        List<Herramienta> herramientas = repository.findByCategoriaHerramienta_Id(categoriaId);

        if (herramientas.isEmpty()) {
            throw new ResourceNotAvailableException("No se encontro la herramienta en la base de datos");
        }

        return herramientas.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<HerramientaResponse> buscar(String nombre) {
        List<Herramienta> herramientas = repository.findByNombreContainingIgnoreCase(nombre);

        if (herramientas.isEmpty()) {
            throw new ResourceNotAvailableException("No se encontro la herramienta en la base de datos");
        }

        return herramientas.stream()
                .map(this::mapToDto)
                .toList();
    }

    private HerramientaResponse mapToDto(Herramienta h) {

        String nombreCategoria = (h.getCategoriaHerramienta() != null)
                ? h.getCategoriaHerramienta().getNombre()
                : null;

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

