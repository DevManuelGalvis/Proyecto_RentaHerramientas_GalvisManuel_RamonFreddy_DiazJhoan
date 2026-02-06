package com.campus.backendproject.dto.incidencia;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ReporteIncidenciaRequest {

    @NotBlank(message = "La descripcion de la incidencia es obligatoria para el historial de la herramienta")
    @Size(min = 10, message = "Por favor, proporcione una descripcion mas detallada (minimo 10 caracteres)")
    private String descripcion;

    @NotNull(message = "El costo de reparacion es obligatorio (puede ser 0.0 si esta cubierto)")
    @DecimalMin(value = "0.0", message = "El costo de reparación no puede ser negativo")
    private BigDecimal costoReparacion;

    @NotNull(message = "Debe indicar el ID de la herramienta afectada")
    private Long herramientaId;

    @NotNull(message = "Debe indicar el ID del proveedor que reporta")
    private Long proveedorId;

    public ReporteIncidenciaRequest() {}

    public ReporteIncidenciaRequest(String descripcion, BigDecimal costoReparacion, Long herramientaId, Long proveedorId) {
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.herramientaId = herramientaId;
        this.proveedorId = proveedorId;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getCostoReparacion() { return costoReparacion; }
    public void setCostoReparacion(BigDecimal costoReparacion) { this.costoReparacion = costoReparacion; }

    public Long getHerramientaId() { return herramientaId; }
    public void setHerramientaId(Long herramientaId) { this.herramientaId = herramientaId; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
}
