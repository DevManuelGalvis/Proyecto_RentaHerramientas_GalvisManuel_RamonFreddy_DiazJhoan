package com.campus.backendproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProveedorRequest {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    @Size(max = 200, message = "El nombre de la empresa no puede tener mas de 200 caracteres")
    private String nombreEmpresa;

    @NotBlank(message = "El RUT es obligatorio")
    @Size(max = 50, message = "El RUT no puede tener mas de 50 caracteres")
    private String rut;

    @Size(max = 1000, message = "La descripcion no puede tener mas de 1000 caracteres")
    private String descripcion;

    public ProveedorRequest() {
    }

    public ProveedorRequest(Long usuarioId, String nombreEmpresa, String rut, String descripcion) {
        this.usuarioId = usuarioId;
        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.descripcion = descripcion;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}