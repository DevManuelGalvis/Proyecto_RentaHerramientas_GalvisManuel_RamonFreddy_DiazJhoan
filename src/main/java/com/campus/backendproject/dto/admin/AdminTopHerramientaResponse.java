package com.campus.backendproject.dto.admin;

public class AdminTopHerramientaResponse {
    private String nombreHerramienta;
    private Long totalAlquileres;

    public AdminTopHerramientaResponse(String nombreHerramienta, Long totalAlquileres) {
        this.nombreHerramienta = nombreHerramienta;
        this.totalAlquileres = totalAlquileres;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public Long getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(Long totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }
}
