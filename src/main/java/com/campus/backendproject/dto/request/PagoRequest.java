package com.campus.backendproject.dto.request;

import com.campus.backendproject.enums.MetodoPago;
import com.campus.backendproject.enums.EstadoPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class PagoRequest {

    @NotNull(message = "El ID de la reserva es obligatorio")
    private Long reservaId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    @NotNull(message = "El metodo de pago es obligatorio")
    private MetodoPago metodoPago;

    @NotNull(message = "El estado del pago es obligatorio")
    private EstadoPago estadoPago;

    @NotBlank(message = "El numero de transaccion es obligatorio")
    @Size(max = 100, message = "El numero de transaccion no puede tener mas de 100 caracteres")
    private String numeroTransaccion;

    @Size(max = 255, message = "El comprobante de pago no puede tener mas de 255 caracteres")
    private String comprobantePago;

    public PagoRequest() {
    }

    public PagoRequest(Long reservaId, BigDecimal monto, MetodoPago metodoPago, EstadoPago estadoPago,
                       String numeroTransaccion, String comprobantePago) {
        this.reservaId = reservaId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.numeroTransaccion = numeroTransaccion;
        this.comprobantePago = comprobantePago;
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