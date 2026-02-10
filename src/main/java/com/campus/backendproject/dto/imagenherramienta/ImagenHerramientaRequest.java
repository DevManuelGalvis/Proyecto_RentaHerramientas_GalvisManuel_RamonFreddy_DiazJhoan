package com.campus.backendproject.dto.imagenherramienta;

public class ImagenHerramientaRequest {
    private String urlImagen;
    private Long herramientaId;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }
}
