package com.campus.backendproject.dto.admin;

import com.campus.backendproject.enums.Roles;

public class AdminUsuarioResponse {

    private Long id;
    private String nombre;
    private String correo;
    private String documento;
    private Roles rol;

    public AdminUsuarioResponse(Long id, String nombre, String correo, String documento, Roles rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;
        this.rol = rol;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getDocumento() { return documento; }
    public Roles getRol() { return rol; }
}
