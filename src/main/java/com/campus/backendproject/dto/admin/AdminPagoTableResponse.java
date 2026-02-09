package com.campus.backendproject.dto.admin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdminPagoTableResponse {

    private Long pagoId;
    private Long facturaId;
    private String cliente;
    private String concepto;
    private BigDecimal monto;
    private LocalDateTime fechaPago;
    private LocalDateTime vencimiento;
    private String estado;

    public AdminPagoTableResponse(
            Long pagoId,
            Long facturaId,
            String cliente,
            String concepto,
            BigDecimal monto,
            LocalDateTime fechaPago,
            LocalDateTime vencimiento,
            String estado
    ) {
        this.pagoId = pagoId;
        this.facturaId = facturaId;
        this.cliente = cliente;
        this.concepto = concepto;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.vencimiento = vencimiento;
        this.estado = estado;
    }

    public Long getPagoId() { return pagoId; }
    public Long getFacturaId() { return facturaId; }
    public String getCliente() { return cliente; }
    public String getConcepto() { return concepto; }
    public BigDecimal getMonto() { return monto; }
    public LocalDateTime getFechaPago() { return fechaPago; }
    public LocalDateTime getVencimiento() { return vencimiento; }
    public String getEstado() { return estado; }
}
