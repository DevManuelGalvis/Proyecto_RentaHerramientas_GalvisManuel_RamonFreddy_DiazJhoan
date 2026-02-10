package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaRequest;
import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaResponse;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.ImagenHerramienta;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.repository.ImagenHerramientaRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorImagenHerramientaService;
import org.springframework.stereotype.Service;

@Service
public class ProveedorImagenHerramientaServiceImpl implements ProveedorImagenHerramientaService {

    private final ImagenHerramientaRepository repository;
    private final HerramientaRepository herramientaRepository;

    // 2. Actualiza el constructor para inyectar ambos
    public ProveedorImagenHerramientaServiceImpl(ImagenHerramientaRepository repository, HerramientaRepository herramientaRepository){
        this.repository = repository;
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    public ImagenHerramientaResponse crearUrl(ImagenHerramientaRequest imagenHerramientaRequest) {
        Herramienta herramienta = herramientaRepository.findById(imagenHerramientaRequest.getHerramientaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe la herramienta con ID: " + imagenHerramientaRequest.getHerramientaId()));

        ImagenHerramienta nuevaImagen = new ImagenHerramienta();
        nuevaImagen.setUrlImagen(imagenHerramientaRequest.getUrlImagen());

        nuevaImagen.setHerramienta(herramienta);

        ImagenHerramienta imagenGuardada = repository.save(nuevaImagen);

        return convertirResponse(imagenGuardada);
    }

    @Override
    public void eliminar(Long id) {
        ImagenHerramienta imagen = repository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No se encontró la imagen con ID: " + id));

        repository.delete(imagen);
    }

    @Override
    public ImagenHerramientaResponse actualizar(Long id, ImagenHerramientaRequest imagenHerramientaRequest) {
        ImagenHerramienta imagenExistente = repository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No se encontró la imagen con ID: " + id));

        if (imagenHerramientaRequest.getHerramientaId() != null) {
            Herramienta nuevaHerramienta = herramientaRepository.findById(imagenHerramientaRequest.getHerramientaId())
                    .orElseThrow(() -> new RegistroNoEncontradoException("La nueva herramienta no existe: " + imagenHerramientaRequest.getHerramientaId()));
            imagenExistente.setHerramienta(nuevaHerramienta);
        }

        imagenExistente.setUrlImagen(imagenHerramientaRequest.getUrlImagen());

        ImagenHerramienta imagenActualizada = repository.save(imagenExistente);

        return convertirResponse(imagenActualizada);
    }

    private ImagenHerramientaResponse convertirResponse(ImagenHerramienta imagenHerramienta){
        return new ImagenHerramientaResponse(
                imagenHerramienta.getId(),
                imagenHerramienta.getUrlImagen(),
                imagenHerramienta.getHerramienta() != null ? imagenHerramienta.getHerramienta().getId() : null
        );
    }
}
