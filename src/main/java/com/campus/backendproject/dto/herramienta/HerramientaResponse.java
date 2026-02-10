package com.campus.backendproject.dto.herramienta;

import com.campus.backendproject.enums.EstadoHerramientas;
import java.math.BigDecimal;

public class HerramientaResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private EstadoHerramientas estado;
    private Integer stock;
    private String nombreCategoria;
    private String nombreEmpresaProveedor;
    private String urlImagen;

    public HerramientaResponse() {}

    public HerramientaResponse(Long id, String nombre, String descripcion, BigDecimal precio,
                               EstadoHerramientas estado, Integer stock, String nombreCategoria,
                               String nombreEmpresaProveedor, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
        this.nombreCategoria = nombreCategoria;
        this.nombreEmpresaProveedor = nombreEmpresaProveedor;
        this.urlImagen = urlImagen;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public EstadoHerramientas getEstado() { return estado; }
    public Integer getStock() { return stock; }
    public String getNombreCategoria() { return nombreCategoria; }
    public String getNombreEmpresaProveedor() { return nombreEmpresaProveedor; }
    public String getUrlImagen() { return urlImagen; }
}
