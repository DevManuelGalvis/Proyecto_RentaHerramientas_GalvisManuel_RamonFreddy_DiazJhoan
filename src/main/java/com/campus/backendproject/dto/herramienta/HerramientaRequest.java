package com.campus.backendproject.dto.herramienta;

import com.campus.backendproject.enums.EstadoHerramientas;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class HerramientaRequest {

    @NotBlank(message = "El nombre de la herramienta es obligatorio")
    @Size(max = 90, message = "El nombre no puede superar los 90 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal precio;

    @NotNull(message = "El estado de la herramienta es obligatorio")
    private EstadoHerramientas estado;

    @NotNull(message = "La categoria es obligatoria")
    private Long categoriaId;

    @NotNull(message = "El proveedor es obligatorio")
    private Long proveedorId;

    public HerramientaRequest() {}

    public HerramientaRequest(String nombre, String descripcion, BigDecimal precio,
                              EstadoHerramientas estado, Long categoriaId, Long proveedorId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public EstadoHerramientas getEstado() { return estado; }
    public void setEstado(EstadoHerramientas estado) { this.estado = estado; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
}
