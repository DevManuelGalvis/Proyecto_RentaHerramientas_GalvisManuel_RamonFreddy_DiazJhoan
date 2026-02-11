package com.campus.backendproject.dto.request;

import com.campus.backendproject.enums.EstadoReserva;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaRequest {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "El ID de la herramienta es obligatorio")
    private Long herramientaId;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @NotNull(message = "Los dias de alquiler son obligatorios")
    @Positive(message = "Los dias de alquiler deben ser mayor a cero")
    private Integer diasAlquiler;

    @NotNull(message = "El costo total es obligatorio")
    @Positive(message = "El costo total debe ser mayor a cero")
    private BigDecimal costoTotal;

    @NotNull(message = "El estado de la reserva es obligatorio")
    private EstadoReserva estado;

    @Size(max = 255, message = "La direccion de entrega no puede tener mas de 255 caracteres")
    private String direccionEntrega;

    @Size(max = 1000, message = "Las notas no pueden tener mas de 1000 caracteres")
    private String notasCliente;

    public ReservaRequest() {
    }

    public ReservaRequest(Long clienteId, Long herramientaId, LocalDate fechaInicio, LocalDate fechaFin,
                          Integer diasAlquiler, BigDecimal costoTotal, EstadoReserva estado,
                          String direccionEntrega, String notasCliente) {
        this.clienteId = clienteId;
        this.herramientaId = herramientaId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasAlquiler = diasAlquiler;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.direccionEntrega = direccionEntrega;
        this.notasCliente = notasCliente;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(Integer diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getNotasCliente() {
        return notasCliente;
    }

    public void setNotasCliente(String notasCliente) {
        this.notasCliente = notasCliente;
    }
}