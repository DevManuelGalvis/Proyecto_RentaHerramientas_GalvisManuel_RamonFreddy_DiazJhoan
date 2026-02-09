package com.campus.backendproject.service.impl;

import com.campus.backendproject.dto.categoria.CategoriaRequest;
import com.campus.backendproject.dto.categoria.CategoriaResponse;
import com.campus.backendproject.entity.CategoriaHerramienta;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.CategoriaRepository;
import com.campus.backendproject.service.interfaz.CategoriaHerramientaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaHerramientasServiceImpl implements CategoriaHerramientaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaHerramientasServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaResponse buscarCategoriaPorNombre(CategoriaRequest categoriaRequest) {
        CategoriaHerramienta categoriaHerramienta = categoriaRepository.findByNombre(categoriaRequest.getNombre());

        if (categoriaHerramienta == null) {
            throw new RegistroNoEncontradoException("El nombre no existe en el sistema");
        }
        return convertirResponse(categoriaHerramienta);
    }

    private CategoriaResponse convertirResponse(CategoriaHerramienta categoriaHerramienta) {
        return new CategoriaResponse(
                categoriaHerramienta.getId(),
                categoriaHerramienta.getNombre()
        );
    }
}
