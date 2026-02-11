package com.campus.backendproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class FacturaRequest {

    @NotNull(message = "El ID del pago es obligatorio")
    private Long pagoId;

    @NotBlank(message = "El numero de factura es obligatorio")
    @Size(max = 50, message = "El numero de factura no puede tener mas de 50 caracteres")
    private String numeroFactura;

    @NotNull(message = "El total es obligatorio")
    @Positive(message = "El total debe ser mayor a cero")
    private BigDecimal total;

    @Size(max = 255, message = "La URL del PDF no puede tener mas de 255 caracteres")
    private String urlPDF;

    public FacturaRequest() {
    }

    public FacturaRequest(Long pagoId, String numeroFactura, BigDecimal total, String urlPDF) {
        this.pagoId = pagoId;
        this.numeroFactura = numeroFactura;
        this.total = total;
        this.urlPDF = urlPDF;
    }

    public Long getPagoId() {
        return pagoId;
    }

    public void setPagoId(Long pagoId) {
        this.pagoId = pagoId;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getUrlPDF() {
        return urlPDF;
    }

    public void setUrlPDF(String urlPDF) {
        this.urlPDF = urlPDF;
    }
}