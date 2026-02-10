package com.campus.backendproject.dto.imagenherramienta;

public class ImagenHerramientaResponse {
    private Long id;
    private String urlImagen;
    private Long herramientaId;

    public ImagenHerramientaResponse(Long id, String urlImagen, Long herramientaId) {
        this.id = id;
        this.urlImagen = urlImagen;
        this.herramientaId = herramientaId;
    }

    public Long getId() {
        return id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }
}
