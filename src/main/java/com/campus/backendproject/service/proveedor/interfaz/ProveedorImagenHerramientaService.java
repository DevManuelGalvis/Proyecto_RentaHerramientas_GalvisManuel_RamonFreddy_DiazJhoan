package com.campus.backendproject.service.proveedor.interfaz;

import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaRequest;
import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaResponse;

public interface ProveedorImagenHerramientaService {
    ImagenHerramientaResponse crearUrl(ImagenHerramientaRequest imagenHerramientaRequest);

    void eliminar(Long id);

    ImagenHerramientaResponse actualizar(Long id, ImagenHerramientaRequest imagenHerramientaRequest);
}
