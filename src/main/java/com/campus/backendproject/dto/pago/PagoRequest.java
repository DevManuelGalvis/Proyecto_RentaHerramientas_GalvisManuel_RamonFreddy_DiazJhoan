package com.campus.backendproject.dto.pago;

import com.campus.backendproject.enums.MetodoPago;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PagoRequest {

    @NotNull(message = "El monto del pago es obligatorio")
    @DecimalMin(value = "0.0", message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    @NotNull(message = "Debe especificar el metodo de pago")
    private MetodoPago metodoPago;

    @NotNull(message = "El ID de la reserva es obligatorio para procesar el pago")
    private Long reservaId;

    public PagoRequest() {}

    public PagoRequest(BigDecimal monto, MetodoPago metodoPago, Long reservaId) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.reservaId = reservaId;
    }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
}
