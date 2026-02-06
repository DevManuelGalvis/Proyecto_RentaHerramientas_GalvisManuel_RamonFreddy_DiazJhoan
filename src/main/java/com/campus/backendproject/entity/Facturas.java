package com.campus.backendproject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_factura", nullable = false, unique = true, length = 30)
    private String numeroFactura;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @OneToOne
    @JoinColumn(name = "pago_id", nullable = false)
    private Pagos pago;

    public Facturas() {}

    public Facturas(String numeroFactura, LocalDateTime fechaEmision, BigDecimal total) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public Long getId() {
        return id;
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

    public Pagos getPagos() {
        return pago;
    }

    public void setPagos(Pagos pagos) {
        this.pago = pagos;
    }
}
