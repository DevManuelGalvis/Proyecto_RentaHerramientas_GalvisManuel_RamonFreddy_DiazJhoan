package com.campus.backendproject.dto.request;

import com.campus.backendproject.enums.EstadoHerramienta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class HerramientaRequest {

    @NotNull(message = "El ID del proveedor es obligatorio")
    private Long proveedorId;

    @NotNull(message = "El ID de la categoria es obligatorio")
    private Long categoriaId;

    @NotBlank(message = "El nombre de la herramienta es obligatorio")
    @Size(max = 200, message = "El nombre no puede tener mas de 200 caracteres")
    private String nombre;

    @Size(max = 1000, message = "La descripcion no puede tener mas de 1000 caracteres")
    private String descripcion;

    @Size(max = 100, message = "La marca no puede tener mas de 100 caracteres")
    private String marca;

    @Size(max = 100, message = "El modelo no puede tener mas de 100 caracteres")
    private String modelo;

    @Size(max = 255, message = "La URL de la imagen no puede tener mas de 255 caracteres")
    private String imagenUrl;

    @NotNull(message = "El precio por dia es obligatorio")
    @Positive(message = "El precio por dia debe ser mayor a cero")
    private BigDecimal precioPorDia;

    @Positive(message = "El precio por semana debe ser mayor a cero")
    private BigDecimal precioPorSemana;

    @NotNull(message = "El estado de la herramienta es obligatorio")
    private EstadoHerramienta estado;

    @NotNull(message = "La disponibilidad es obligatoria")
    private Boolean disponible;

    @NotNull(message = "La cantidad disponible es obligatoria")
    @Positive(message = "La cantidad disponible debe ser mayor a cero")
    private Integer cantidadDisponible;

    @Size(max = 1000, message = "Las especificaciones tecnicas no pueden tener mas de 1000 caracteres")
    private String especificacionesTecnicas;

    public HerramientaRequest() {
    }

    public HerramientaRequest(Long proveedorId, Long categoriaId, String nombre, String descripcion,
                              String marca, String modelo, String imagenUrl, BigDecimal precioPorDia,
                              BigDecimal precioPorSemana, EstadoHerramienta estado, Boolean disponible,
                              Integer cantidadDisponible, String especificacionesTecnicas) {
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.imagenUrl = imagenUrl;
        this.precioPorDia = precioPorDia;
        this.precioPorSemana = precioPorSemana;
        this.estado = estado;
        this.disponible = disponible;
        this.cantidadDisponible = cantidadDisponible;
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public BigDecimal getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(BigDecimal precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public BigDecimal getPrecioPorSemana() {
        return precioPorSemana;
    }

    public void setPrecioPorSemana(BigDecimal precioPorSemana) {
        this.precioPorSemana = precioPorSemana;
    }

    public EstadoHerramienta getEstado() {
        return estado;
    }

    public void setEstado(EstadoHerramienta estado) {
        this.estado = estado;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }
}