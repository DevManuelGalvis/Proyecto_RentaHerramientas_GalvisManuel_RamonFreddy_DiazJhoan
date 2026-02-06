package com.campus.backendproject.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteRequest {

    @NotBlank(message = "El telefono es necesario para coordinar las entregas")
    @Size(max = 30)
    private String telefono;

    @NotBlank(message = "La direccion de residencia o entrega es obligatoria")
    private String direccion;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    public ClienteRequest() {}

    public ClienteRequest(String telefono, String direccion, Long usuarioId) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuarioId = usuarioId;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}