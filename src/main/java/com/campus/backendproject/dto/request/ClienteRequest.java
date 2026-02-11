package com.campus.backendproject.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteRequest {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @Size(max = 50, message = "El documento de identidad no puede tener mas de 50 caracteres")
    private String documentoIdentidad;

    public ClienteRequest() {
    }

    public ClienteRequest(Long usuarioId, String documentoIdentidad) {
        this.usuarioId = usuarioId;
        this.documentoIdentidad = documentoIdentidad;
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