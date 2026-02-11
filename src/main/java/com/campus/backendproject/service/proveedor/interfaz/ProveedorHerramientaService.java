package com.campus.backendproject.service.proveedor.interfaz;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProveedorHerramientaService {

    HerramientaResponse crearHerramienta(HerramientaRequest herramientaRequest);

    HerramientaResponse actualizarHerramienta(
            Long id,
            HerramientaRequest herramientaRequest
    );

    void eliminarHerramienta(Long id);

    Page<HerramientaResponse> listarPorProveedor(
            Long proveedorId,
            String search,
            Long categoriaId,
            EstadoHerramientas estado,
            Pageable pageable
    );
}
