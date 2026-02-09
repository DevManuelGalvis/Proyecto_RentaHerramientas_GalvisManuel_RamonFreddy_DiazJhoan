package com.campus.backendproject.controller.proveedor;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.service.proveedor.impl.ProveedorHerramientaServiceImpl;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorHerramientaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor")
public class ProveedorHerramientaController {
    private final ProveedorHerramientaServiceImpl service;

    public  ProveedorHerramientaController(ProveedorHerramientaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HerramientaResponse> crear(@Valid @RequestBody HerramientaRequest  herramientaRequest) {
        HerramientaResponse creada = service.crearHerramienta(herramientaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminarHerramienta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HerramientaResponse> actualizar(@PathVariable Long id, @Valid @RequestBody HerramientaRequest herramientaRequest){
        return ResponseEntity.ok(service.actualizarHerramienta(id, herramientaRequest));
    }
}
