package com.campus.backendproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reporte_incidencias")
public class ReporteIncidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "costo_reparacion", nullable = false, precision = 10, scale = 2)
    private BigDecimal costoReparacion;

    @Column(name = "fecha_reporte", nullable = false)
    private LocalDateTime fechaReporte;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramientas herramienta;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    public ReporteIncidencias() {}

    public ReporteIncidencias(String descripcion, BigDecimal costoReparacion, LocalDateTime fechaReporte) {
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.fechaReporte = fechaReporte;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(BigDecimal costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
