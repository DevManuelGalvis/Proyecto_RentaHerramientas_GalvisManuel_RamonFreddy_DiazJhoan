package com.campus.backendproject.dto.proveedor;

public class ProveedorResponse {

    private Long id;
    private String nombreEmpresa;
    private String telefono;
    private String direccion;
    private String correoElectronico;
    private String documentoIdentidad;

    public ProveedorResponse() {}

    public ProveedorResponse(Long id, String nombreEmpresa, String telefono, String direccion,
                             String correoElectronico, String documentoIdentidad) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Long getId() { return id; }

    public String getNombreEmpresa() { return nombreEmpresa; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getCorreoElectronico() { return correoElectronico; }

    public String getDocumentoIdentidad() { return documentoIdentidad; }
}
