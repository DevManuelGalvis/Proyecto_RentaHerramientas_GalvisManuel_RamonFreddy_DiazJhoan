package com.campus.backendproject.controller.proveedor;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorHerramientaService;
import com.campus.backendproject.service.seguridad.interfaz.SeguridadService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor")
public class ProveedorHerramientaController {

    private final ProveedorHerramientaService service;
    private final SeguridadService seguridadService;

    public ProveedorHerramientaController(
            ProveedorHerramientaService service,
            SeguridadService seguridadService
    ) {
        this.service = service;
        this.seguridadService = seguridadService;
    }

    // ✅ Crear herramienta (proveedor desde JWT)
    @PostMapping
    public ResponseEntity<HerramientaResponse> crear(
            @Valid @RequestBody HerramientaRequest request
    ) {
        HerramientaResponse creada = service.crearHerramienta(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // ✅ Actualizar herramienta
    @PutMapping("/{id}")
    public ResponseEntity<HerramientaResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody HerramientaRequest request
    ) {
        return ResponseEntity.ok(service.actualizarHerramienta(id, request));
    }

    // ✅ Eliminar herramienta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarHerramienta(id);
        return ResponseEntity.noContent().build();
    }

    // 📊 Listado del proveedor con filtros + paginación
    @GetMapping("/herramientas")
    public Page<HerramientaResponse> listarHerramientasProveedor(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) EstadoHerramientas estado,
            Pageable pageable
    ) {

        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();

        return service.listarPorProveedor(
                proveedorId,
                search,
                categoriaId,
                estado,
                pageable
        );
    }
}
