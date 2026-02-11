package com.campus.backendproject.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FacturaResponse {

    private Long id;
    private Long pagoId;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private BigDecimal total;
    private String urlPDF;

    public FacturaResponse() {
    }

    public FacturaResponse(Long id, Long pagoId, String numeroFactura, LocalDateTime fechaEmision,
                           BigDecimal total, String urlPDF) {
        this.id = id;
        this.pagoId = pagoId;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.urlPDF = urlPDF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
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