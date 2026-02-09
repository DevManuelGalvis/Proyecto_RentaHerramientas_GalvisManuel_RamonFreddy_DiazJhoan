package com.campus.backendproject.dto.admin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdminPagoResponse {

    private Long id;
    private BigDecimal monto;
    private String metodo;
    private String estado;
    private LocalDateTime fecha;
    private Long reservaId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
}
