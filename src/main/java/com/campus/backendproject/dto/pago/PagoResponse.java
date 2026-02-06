package com.campus.backendproject.dto.pago;

import com.campus.backendproject.enums.EstadoPago;
import com.campus.backendproject.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {

    private Long id;
    private BigDecimal monto;
    private MetodoPago metodoPago;
    private EstadoPago estadoPago;
    private LocalDateTime fechaPago;
    private Long reservaId;
    private String numeroFactura;

    public PagoResponse() {}

    public PagoResponse(Long id, BigDecimal monto, MetodoPago metodoPago, EstadoPago estadoPago,
                        LocalDateTime fechaPago, Long reservaId, String numeroFactura) {
        this.id = id;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
        this.reservaId = reservaId;
        this.numeroFactura = numeroFactura;
    }

    public Long getId() { return id; }

    public BigDecimal getMonto() { return monto; }

    public MetodoPago getMetodoPago() { return metodoPago; }

    public EstadoPago getEstadoPago() { return estadoPago; }

    public LocalDateTime getFechaPago() { return fechaPago; }

    public Long getReservaId() { return reservaId; }

    public String getNumeroFactura() { return numeroFactura; }
}
