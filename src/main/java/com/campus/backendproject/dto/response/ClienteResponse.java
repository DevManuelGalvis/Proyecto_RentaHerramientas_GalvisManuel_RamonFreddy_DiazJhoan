package com.campus.backendproject.dto.response;

public class ClienteResponse {

    private Long id;
    private Long usuarioId;
    private String documentoIdentidad;

    public ClienteResponse() {
    }

    public ClienteResponse(Long id, Long usuarioId, String documentoIdentidad) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
}