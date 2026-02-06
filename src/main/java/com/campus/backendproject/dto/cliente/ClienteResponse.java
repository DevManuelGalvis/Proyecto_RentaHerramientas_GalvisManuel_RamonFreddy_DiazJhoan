package com.campus.backendproject.dto.cliente;

public class ClienteResponse {

    private Long id;
    private String telefono;
    private String direccion;
    private String nombre;
    private String correo;
    private String documento;

    public ClienteResponse() {}

    public ClienteResponse(Long id, String telefono, String direccion,
                           String nombre, String correo, String documento) {
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;
    }

    public Long getId() { return id; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public String getNombre() { return nombre; }

    public String getCorreo() { return correo; }

    public String getDocumento() { return documento; }
}
