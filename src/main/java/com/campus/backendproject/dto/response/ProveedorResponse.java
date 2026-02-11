package com.campus.backendproject.dto.response;

public class ProveedorResponse {

    private Long id;
    private Long usuarioId;
    private String nombreEmpresa;
    private String rut;
    private String descripcion;

    public ProveedorResponse() {
    }

    public ProveedorResponse(Long id, Long usuarioId, String nombreEmpresa, String rut, String descripcion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.descripcion = descripcion;
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