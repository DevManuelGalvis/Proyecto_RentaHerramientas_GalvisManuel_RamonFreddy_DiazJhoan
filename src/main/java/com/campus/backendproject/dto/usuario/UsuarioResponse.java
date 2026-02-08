package com.campus.backendproject.dto.usuario;

import com.campus.backendproject.enums.Roles;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String correo;
    private String documento;
    private Roles rol;

    private String infoAdicional;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String nombre, String correo, String documento, Roles rol, String infoAdicional) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;
        this.rol = rol;
        this.infoAdicional = infoAdicional;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }

    public String getCorreo() { return correo; }

    public String getDocumento() { return documento; }

    public Roles getRol() { return rol; }

    public String getInfoAdicional() { return infoAdicional; }
}