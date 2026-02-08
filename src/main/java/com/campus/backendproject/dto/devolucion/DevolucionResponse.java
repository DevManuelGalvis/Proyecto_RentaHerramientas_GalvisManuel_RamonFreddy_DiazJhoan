package com.campus.backendproject.dto.devolucion;

import com.campus.backendproject.enums.EstadoDevolucion;

import java.time.LocalDateTime;

public class DevolucionResponse {

    private Long id;
    private LocalDateTime fechaDevolucion;
    private EstadoDevolucion estadoDevolucion;
    private String observaciones;
    private Long reservaId;
    private String nombreHerramienta;

    public DevolucionResponse() {}

    public DevolucionResponse(Long id, LocalDateTime fechaDevolucion, EstadoDevolucion estadoDevolucion,
                              String observaciones, Long reservaId, String nombreHerramienta) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoDevolucion = estadoDevolucion;
        this.observaciones = observaciones;
        this.reservaId = reservaId;
        this.nombreHerramienta = nombreHerramienta;
    }

    public Long getId() { return id; }

    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }

    public EstadoDevolucion getEstadoDevolucion() { return estadoDevolucion; }

    public String getObservaciones() { return observaciones; }

    public Long getReservaId() { return reservaId; }

    public String getNombreHerramienta() { return nombreHerramienta; }
}
