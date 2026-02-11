package com.campus.backendproject.dto.response;

import com.campus.backendproject.enums.EstadoHerramienta;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HerramientaResponse {

    private Long id;
    private Long proveedorId;
    private String nombreProveedor;
    private Long categoriaId;
    private String nombreCategoria;
    private String nombre;
    private String descripcion;
    private String marca;
    private String modelo;
    private String imagenUrl;
    private BigDecimal precioPorDia;
    private BigDecimal precioPorSemana;
    private EstadoHerramienta estado;
    private Boolean disponible;
    private Integer cantidadDisponible;
    private String especificacionesTecnicas;
    private LocalDateTime fechaRegistro;

    public HerramientaResponse() {
    }

    public HerramientaResponse(Long id, Long proveedorId, String nombreProveedor, Long categoriaId,
                               String nombreCategoria, String nombre, String descripcion, String marca,
                               String modelo, String imagenUrl, BigDecimal precioPorDia,
                               BigDecimal precioPorSemana, EstadoHerramienta estado, Boolean disponible,
                               Integer cantidadDisponible, String especificacionesTecnicas,
                               LocalDateTime fechaRegistro) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.nombreProveedor = nombreProveedor;
        this.categoriaId = categoriaId;
        this.nombreCategoria = nombreCategoria;
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
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}