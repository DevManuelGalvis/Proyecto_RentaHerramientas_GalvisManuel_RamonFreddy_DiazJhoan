package com.campus.backendproject.dto.proveedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProveedorRequest {

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombreEmpresa;

    @NotBlank(message = "El telefono de contacto es obligatorio")
    @Size(max = 30)
    private String telefono;

    @NotBlank(message = "La direccion fiscal es obligatoria")
    private String direccion;

    @NotNull(message = "El ID de usuario es necesario")
    private Long usuarioId;

    public ProveedorRequest() {}

    public ProveedorRequest(String nombreEmpresa, String telefono, String direccion, Long usuarioId) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuarioId = usuarioId;
    }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
