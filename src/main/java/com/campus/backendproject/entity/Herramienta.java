package com.campus.backendproject.entity;

import com.campus.backendproject.enums.EstadoHerramientas;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "herramientas")
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoHerramientas estado;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaHerramienta categoriaHerramienta;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReporteIncidencia> reporteIncidencias = new ArrayList<>();

    @OneToOne(mappedBy = "herramienta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ImagenHerramienta imagenesHerramientas;

    public Herramienta() {}

    public Herramienta(String nombre, String descripcion, BigDecimal precio, EstadoHerramientas estado, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
    }

    public Long getId() {
        return id;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public EstadoHerramientas getEstado() {
        return estado;
    }

    public void setEstado(EstadoHerramientas estado) {
        this.estado = estado;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public CategoriaHerramienta getCategoriaHerramienta() {
        return categoriaHerramienta;
    }

    public void setCategoriaHerramienta(CategoriaHerramienta categoriaHerramienta) {
        this.categoriaHerramienta = categoriaHerramienta;
    }

    public List<ReporteIncidencia> getReporteIncidencias() {
        return reporteIncidencias;
    }

    public void setReporteIncidencias(List<ReporteIncidencia> reporteIncidencias) {
        this.reporteIncidencias = reporteIncidencias;
    }

    public ImagenHerramienta getImagenesHerramientas() {
        return imagenesHerramientas;
    }

    public void setImagenesHerramientas(ImagenHerramienta imagenesHerramientas) {
        this.imagenesHerramientas = imagenesHerramientas;
    }
}
