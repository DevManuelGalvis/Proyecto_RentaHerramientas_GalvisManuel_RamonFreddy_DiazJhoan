package com.campus.backendproject.entity;

import com.campus.backendproject.enums.EstadoPago;
import com.campus.backendproject.enums.Metodo_Pago;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private Metodo_Pago metodo_pago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado_pago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fecha_pago;

    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reservas reserva;

    @OneToOne(mappedBy = "pago", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Facturas facturas;

    public Pagos() {}

    public Pagos(BigDecimal monto, Metodo_Pago metodo_pago, EstadoPago estado_pago, LocalDateTime fecha_pago) {
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.estado_pago = estado_pago;
        this.fecha_pago = fecha_pago;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Metodo_Pago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(Metodo_Pago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public EstadoPago getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(EstadoPago estado_pago) {
        this.estado_pago = estado_pago;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Reservas getReservas() {
        return reserva;
    }

    public void setReservas(Reservas reservas) {
        this.reserva = reservas;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }
}
