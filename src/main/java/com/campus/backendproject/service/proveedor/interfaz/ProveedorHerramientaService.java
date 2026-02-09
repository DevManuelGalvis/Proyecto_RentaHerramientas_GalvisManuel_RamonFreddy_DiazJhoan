package com.campus.backendproject.service.proveedor.interfaz;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;

public interface ProveedorHerramientaService {
    HerramientaResponse crearHerramienta(HerramientaRequest herramientaRequest);
    void eliminarHerramienta(Long id);
    HerramientaResponse actualizarHerramienta(Long id, HerramientaRequest herramientaRequest);
}
