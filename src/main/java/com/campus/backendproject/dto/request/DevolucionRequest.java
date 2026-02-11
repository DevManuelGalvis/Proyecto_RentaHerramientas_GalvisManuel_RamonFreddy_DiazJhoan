package com.campus.backendproject.dto.request;

import com.campus.backendproject.enums.EstadoEquipo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DevolucionRequest {

    @NotNull(message = "El ID de la reserva es obligatorio")
    private Long reservaId;

    @NotNull(message = "El estado del equipo es obligatorio")
    private EstadoEquipo estadoEquipo;

    @Size(max = 1000, message = "El reporte de danos no puede tener mas de 1000 caracteres")
    private String reporteDanos;

    @NotNull(message = "La aceptacion del proveedor es obligatoria")
    private Boolean aceptadoPorProveedor;

    public DevolucionRequest() {
    }

    public DevolucionRequest(Long reservaId, EstadoEquipo estadoEquipo, String reporteDanos,
                             Boolean aceptadoPorProveedor) {
        this.reservaId = reservaId;
        this.estadoEquipo = estadoEquipo;
        this.reporteDanos = reporteDanos;
        this.aceptadoPorProveedor = aceptadoPorProveedor;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
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