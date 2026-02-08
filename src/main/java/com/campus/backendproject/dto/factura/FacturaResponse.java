package com.campus.backendproject.dto.factura;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FacturaResponse {

    private Long id;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private BigDecimal total;
    private Long pagoId;
    private Long reservaId;
    private String nombreCliente;

    public FacturaResponse() {}

    public FacturaResponse(Long id, String numeroFactura, LocalDateTime fechaEmision,
                           BigDecimal total, Long pagoId, Long reservaId, String nombreCliente) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.pagoId = pagoId;
        this.reservaId = reservaId;
        this.nombreCliente = nombreCliente;
    }

    public Long getId() { return id; }

    public String getNumeroFactura() { return numeroFactura; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }

    public BigDecimal getTotal() { return total; }

    public Long getPagoId() { return pagoId; }

    public Long getReservaId() { return reservaId; }

    public String getNombreCliente() { return nombreCliente; }
}
