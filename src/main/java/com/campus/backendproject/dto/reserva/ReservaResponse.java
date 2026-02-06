package com.campus.backendproject.dto.reserva;

import com.campus.backendproject.enums.EstadoReserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservaResponse {

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoReserva estado;
    private BigDecimal total;
    private String nombreCliente;
    private String nombreHerramienta;
    private Long herramientaId;

    public ReservaResponse() {}

    public ReservaResponse(Long id, LocalDateTime fechaInicio, LocalDateTime fechaFin,
                           EstadoReserva estado, BigDecimal total, String nombreCliente,
                           String nombreHerramienta, Long herramientaId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.total = total;
        this.nombreCliente = nombreCliente;
        this.nombreHerramienta = nombreHerramienta;
        this.herramientaId = herramientaId;
    }

    public Long getId() { return id; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }

    public EstadoReserva getEstado() { return estado; }

    public BigDecimal getTotal() { return total; }

    public String getNombreCliente() { return nombreCliente; }

    public String getNombreHerramienta() { return nombreHerramienta; }

    public Long getHerramientaId() { return herramientaId; }
}
