package com.campus.backendproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefono", nullable = false, length = 30)
    private String telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reservas> reservas = new ArrayList<>();

    public Clientes () {}

    public Clientes(String telefono, String direccion, Usuario usuario) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
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

    public List<Reservas> getReservas() {
        return new ArrayList<>(reservas);
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }
}
