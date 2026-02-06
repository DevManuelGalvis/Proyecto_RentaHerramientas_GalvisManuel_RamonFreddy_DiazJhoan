package com.campus.backendproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_herramientas")
public class CategoriaHerramientas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "categoriaHerramienta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Herramientas> herramientas = new ArrayList<>();

    public CategoriaHerramientas (){}

    public CategoriaHerramientas(String nombre) {
        this.nombre = nombre;
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

    public List<Herramientas> getHerramientas() {
        return new ArrayList<>(herramientas);
    }

    public void setHerramientas(List<Herramientas> herramientas) {
        this.herramientas = herramientas;
    }
}
