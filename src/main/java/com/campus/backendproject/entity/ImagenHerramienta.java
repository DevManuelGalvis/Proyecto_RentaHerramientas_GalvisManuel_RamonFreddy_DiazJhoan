package com.campus.backendproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes_herramientas")
public class ImagenHerramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_imagen", columnDefinition = "TEXT")
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;

    public ImagenHerramienta(){}

    public ImagenHerramienta(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }
}
