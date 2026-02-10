package com.campus.backendproject.controller.proveedor;

import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaRequest;
import com.campus.backendproject.dto.imagenherramienta.ImagenHerramientaResponse;
import com.campus.backendproject.service.proveedor.impl.ProveedorImagenHerramientaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor/imagenes")
public class ProveedorImagenHerramientaController {

    private final ProveedorImagenHerramientaServiceImpl service;

    public ProveedorImagenHerramientaController(ProveedorImagenHerramientaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ImagenHerramientaResponse> crear(@Valid @RequestBody ImagenHerramientaRequest request) {
        ImagenHerramientaResponse creada = service.crearUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenHerramientaResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ImagenHerramientaRequest request) {
        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
