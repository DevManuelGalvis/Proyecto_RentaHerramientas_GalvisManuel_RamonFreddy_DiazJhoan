package com.campus.backendproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empresa", nullable = false, length = 100)
    private String nombreEmpresa;

    @Column(name = "telefono", nullable = false, length = 30)
    private String telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Herramientas> herramientas = new ArrayList<>();

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReporteIncidencias> reporteIncidencias = new ArrayList<>();

    public Proveedor() {}

    public Proveedor(String nombreEmpresa, String telefono, String direccion, Usuario usuario) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Herramientas> getHerramientas() {
        return new ArrayList<>(herramientas);
    }

    public void setHerramientas(List<Herramientas> herramientas) {
        this.herramientas = herramientas;
    }

    public List<ReporteIncidencias> getReporteIncidencias() {
        return new ArrayList<>(reporteIncidencias);
    }

    public void setReporteIncidencias(List<ReporteIncidencias> reporteIncidencias) {
        this.reporteIncidencias = reporteIncidencias;
    }
}
