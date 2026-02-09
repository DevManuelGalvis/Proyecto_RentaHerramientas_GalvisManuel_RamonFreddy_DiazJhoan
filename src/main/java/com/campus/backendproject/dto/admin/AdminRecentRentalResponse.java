package com.campus.backendproject.dto.admin;

import com.campus.backendproject.enums.EstadoReserva;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class AdminRecentRentalResponse {

    private Long id;
    private String nombreCliente;
    private String nombreHerramienta;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoReserva estadoReserva;
    private BigDecimal total;

    public AdminRecentRentalResponse(
            Long id,
            String nombreCliente,
            String nombreHerramienta,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin,
            EstadoReserva estadoReserva,
            BigDecimal total
    ) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.nombreHerramienta = nombreHerramienta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = estadoReserva;
        this.total = total;
    }

    // getters (JPA no necesita setters aquí)

    public Long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
