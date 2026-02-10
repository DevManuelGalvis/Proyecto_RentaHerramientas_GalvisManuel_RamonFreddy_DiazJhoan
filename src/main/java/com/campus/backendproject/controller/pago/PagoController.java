package com.campus.backendproject.controller.pago;

import com.campus.backendproject.dto.pago.PagoRequest;
import com.campus.backendproject.dto.pago.PagoResponse;
import com.campus.backendproject.service.pago.interfaz.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PagoResponse> crear(@Valid @RequestBody PagoRequest req) {
        PagoResponse creada = service.procesarPago(req);
        return ResponseEntity.created(URI.create("/api/pagos/" + creada.getId())).body(creada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}
