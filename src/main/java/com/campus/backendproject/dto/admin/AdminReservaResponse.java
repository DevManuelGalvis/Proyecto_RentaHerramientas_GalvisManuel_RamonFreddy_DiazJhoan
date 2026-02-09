package com.campus.backendproject.dto.admin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdminReservaResponse {

    private Long id;
    private String nombreCliente;
    private String nombreHerramienta;
    private String nombreProveedor;
    private String estadoReserva;
    private BigDecimal total;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private long diasAlquiler;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getNombreHerramienta() { return nombreHerramienta; }
    public void setNombreHerramienta(String nombreHerramienta) { this.nombreHerramienta = nombreHerramienta; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public String getEstadoReserva() { return estadoReserva; }
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = estadoReserva; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public long getDiasAlquiler() { return diasAlquiler; }
    public void setDiasAlquiler(long diasAlquiler) { this.diasAlquiler = diasAlquiler; }
}
