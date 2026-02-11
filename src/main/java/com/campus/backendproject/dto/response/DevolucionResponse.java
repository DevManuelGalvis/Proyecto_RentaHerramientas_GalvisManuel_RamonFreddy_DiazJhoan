package com.campus.backendproject.dto.response;

import com.campus.backendproject.enums.EstadoEquipo;
import java.time.LocalDateTime;

public class DevolucionResponse {

    private Long id;
    private Long reservaId;
    private LocalDateTime fechaDevolucion;
    private EstadoEquipo estadoEquipo;
    private String reporteDanos;
    private Boolean aceptadoPorProveedor;

    public DevolucionResponse() {
    }

    public DevolucionResponse(Long id, Long reservaId, LocalDateTime fechaDevolucion,
                              EstadoEquipo estadoEquipo, String reporteDanos, Boolean aceptadoPorProveedor) {
        this.id = id;
        this.reservaId = reservaId;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoEquipo = estadoEquipo;
        this.reporteDanos = reporteDanos;
        this.aceptadoPorProveedor = aceptadoPorProveedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EstadoEquipo getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(EstadoEquipo estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    public String getReporteDanos() {
        return reporteDanos;
    }

    public void setReporteDanos(String reporteDanos) {
        this.reporteDanos = reporteDanos;
    }

    public Boolean getAceptadoPorProveedor() {
        return aceptadoPorProveedor;
    }

    public void setAceptadoPorProveedor(Boolean aceptadoPorProveedor) {
        this.aceptadoPorProveedor = aceptadoPorProveedor;
    }
}