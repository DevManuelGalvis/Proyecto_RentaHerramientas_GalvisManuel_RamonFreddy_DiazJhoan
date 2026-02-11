package com.campus.backendproject.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false, length = 200)
    private String nombreEmpresa;

    @Column(nullable = false, unique = true, length = 50)
    private String ruc;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public Proveedor() {
    }

    public Proveedor(Long id, Usuario usuario, String nombreEmpresa, String ruc,
                     String descripcion) {
        this.id = id;
        this.usuario = usuario;
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.descripcion = descripcion;

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}