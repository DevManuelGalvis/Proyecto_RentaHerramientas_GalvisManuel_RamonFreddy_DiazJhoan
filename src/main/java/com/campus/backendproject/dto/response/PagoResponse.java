package com.campus.backendproject.dto.response;

import com.campus.backendproject.enums.MetodoPago;
import com.campus.backendproject.enums.EstadoPago;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {

    private Long id;
    private Long reservaId;
    private BigDecimal monto;
    private MetodoPago metodoPago;
    private EstadoPago estadoPago;
    private LocalDateTime fechaPago;
    private String numeroTransaccion;
    private String comprobantePago;

    public PagoResponse() {
    }

    public PagoResponse(Long id, Long reservaId, BigDecimal monto, MetodoPago metodoPago,
                        EstadoPago estadoPago, LocalDateTime fechaPago, String numeroTransaccion,
                        String comprobantePago) {
        this.id = id;
        this.reservaId = reservaId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
        this.numeroTransaccion = numeroTransaccion;
        this.comprobantePago = comprobantePago;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(String comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
}