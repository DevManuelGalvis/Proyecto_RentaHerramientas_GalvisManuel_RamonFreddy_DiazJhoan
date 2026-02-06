package com.campus.backendproject.dto.reserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaRequest {

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha de inicio no puede ser en el pasado")
    private LocalDateTime fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDateTime fechaFin;

    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "La herramienta es obligatoria")
    private Long herramientaId;

    public ReservaRequest() {}

    public ReservaRequest(LocalDateTime fechaInicio, LocalDateTime fechaFin, Long clienteId, Long herramientaId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.clienteId = clienteId;
        this.herramientaId = herramientaId;
    }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getHerramientaId() { return herramientaId; }
    public void setHerramientaId(Long herramientaId) { this.herramientaId = herramientaId; }
}
