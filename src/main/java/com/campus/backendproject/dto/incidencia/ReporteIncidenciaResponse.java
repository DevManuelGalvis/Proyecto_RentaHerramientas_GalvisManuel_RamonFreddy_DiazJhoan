package com.campus.backendproject.dto.incidencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReporteIncidenciaResponse {

    private Long id;
    private String descripcion;
    private BigDecimal costoReparacion;
    private LocalDateTime fechaReporte;
    private String nombreHerramienta;
    private String nombreEmpresaProveedor;

    public ReporteIncidenciaResponse() {}

    public ReporteIncidenciaResponse(Long id, String descripcion, BigDecimal costoReparacion,
                                     LocalDateTime fechaReporte, String nombreHerramienta,
                                     String nombreEmpresaProveedor) {
        this.id = id;
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.fechaReporte = fechaReporte;
        this.nombreHerramienta = nombreHerramienta;
        this.nombreEmpresaProveedor = nombreEmpresaProveedor;
    }

    public Long getId() { return id; }

    public String getDescripcion() { return descripcion; }

    public BigDecimal getCostoReparacion() { return costoReparacion; }

    public LocalDateTime getFechaReporte() { return fechaReporte; }

    public String getNombreHerramienta() { return nombreHerramienta; }

    public String getNombreEmpresaProveedor() { return nombreEmpresaProveedor; }
}