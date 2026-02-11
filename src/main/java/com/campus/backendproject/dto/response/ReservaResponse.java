package com.campus.backendproject.dto.response;

import com.campus.backendproject.enums.EstadoReserva;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaResponse {

    private Long id;
    private Long clienteId;
    private String nombreCliente;
    private Long herramientaId;
    private String nombreHerramienta;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDateTime fechaReserva;
    private Integer diasAlquiler;
    private BigDecimal costoTotal;
    private EstadoReserva estado;
    private String direccionEntrega;
    private String notasCliente;

    public ReservaResponse() {
    }

    public ReservaResponse(Long id, Long clienteId, String nombreCliente, Long herramientaId,
                           String nombreHerramienta, LocalDate fechaInicio, LocalDate fechaFin,
                           LocalDateTime fechaReserva, Integer diasAlquiler, BigDecimal costoTotal,
                           EstadoReserva estado, String direccionEntrega, String notasCliente) {
        this.id = id;
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.herramientaId = herramientaId;
        this.nombreHerramienta = nombreHerramienta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaReserva = fechaReserva;
        this.diasAlquiler = diasAlquiler;
        this.costoTotal = costoTotal;
        this.estado = estado;
        this.direccionEntrega = direccionEntrega;
        this.notasCliente = notasCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
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

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
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