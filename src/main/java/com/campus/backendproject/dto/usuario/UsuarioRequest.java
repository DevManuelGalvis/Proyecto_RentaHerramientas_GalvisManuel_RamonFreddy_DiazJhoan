package com.campus.backendproject.dto.usuario;

import com.campus.backendproject.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 80, message = "El nombre debe tener entre 3 y 80 caracteres")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe proporcionar un formato de correo válido (ejemplo@correo.com)")
    private String correo;

    @NotBlank(message = "El documento de identidad es obligatorio")
    private String documento;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @NotNull(message = "Debe seleccionar un rol (CLIENTE o PROVEEDOR)")
    private Roles rol;

    @NotBlank(message = "La direccion de contacto es obligatoria")
    private String direccion;

    @NotBlank(message = "El telefono es obligatorio para la gestion de alquileres")
    private String telefono;

    private String nombreEmpresa;

    public UsuarioRequest() {}

    public UsuarioRequest(String nombre, String correo, String documento, String password, Roles rol, String direccion, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.documento = documento;
        this.password = password;
        this.rol = rol;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Roles getRol() { return rol; }
    public void setRol(Roles rol) { this.rol = rol; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
}
