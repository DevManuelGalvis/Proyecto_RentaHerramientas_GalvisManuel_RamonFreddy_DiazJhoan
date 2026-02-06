package com.campus.backendproject.entity;

import com.campus.backendproject.enums.EstadoDevolucion;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "devoluciones")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDateTime fechaDevolucion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_equipo", nullable = false)
    private EstadoDevolucion estadoDevolucion;

    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    public Devolucion() {}

    public Devolucion(LocalDateTime fechaDevolucion, EstadoDevolucion estadoDevolucion, String observaciones) {
        this.fechaDevolucion = fechaDevolucion;
        this.estadoDevolucion = estadoDevolucion;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EstadoDevolucion getEstadoDevolucion() {
        return estadoDevolucion;
    }

    public void setEstadoDevolucion(EstadoDevolucion estadoDevolucion) {
        this.estadoDevolucion = estadoDevolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reservas) {
        this.reserva = reservas;
    }
}
