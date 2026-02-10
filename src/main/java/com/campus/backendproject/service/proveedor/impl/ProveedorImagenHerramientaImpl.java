package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaRequest;
import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaResponse;
import com.campus.backendproject.entity.ImagenHerramienta;
import com.campus.backendproject.repository.ImagenHerramientaRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorImagenHerramientaService;
import org.springframework.stereotype.Service;

@Service
public class ProveedorImagenHerramientaImpl implements ProveedorImagenHerramientaService {


    private ImagenHerramientaRepository repository;

    public ProveedorImagenHerramientaImpl(ImagenHerramientaRepository repository){
        this.repository = repository;
    }
    @Override
    public ImagenHerramientaResponse crearUrl(ImagenHerramientaRequest imagenHerramientaRequest) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public ImagenHerramientaResponse actualizar(Long id, ImagenHerramientaRequest imagenHerramientaRequest) {
        return null;
    }

    private ImagenHerramientaResponse convertirResponse(ImagenHerramienta imagenHerramienta){
        return new ImagenHerramientaResponse(
                imagenHerramienta.getId(),
                imagenHerramienta.getUrlImagen(),
                imagenHerramienta.getHerramienta() != null ? imagenHerramienta.getHerramienta().getId() : Long.valueOf("Sin Herramienta")
        );
    }
}
