package com.campus.backendproject.dto.factura;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class FacturaRequest {

    @NotBlank(message = "El numero de factura es obligatorio")
    private String numeroFactura;

    @NotNull(message = "El ID del pago es obligatorio")
    private Long pagoId;

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor a 0")
    private BigDecimal total;

    public FacturaRequest() {}

    public FacturaRequest(String numeroFactura, Long pagoId, BigDecimal total) {
        this.numeroFactura = numeroFactura;
        this.pagoId = pagoId;
        this.total = total;
    }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public Long getPagoId() { return pagoId; }
    public void setPagoId(Long pagoId) { this.pagoId = pagoId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
