package com.campus.backendproject.dto.proveedor;

public class TopHerramientaResponse {

    private String nombre;
    private Long totalRentas;

    public TopHerramientaResponse(String nombre, Long totalRentas) {
        this.nombre = nombre;
        this.totalRentas = totalRentas;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getTotalRentas() {
        return totalRentas;
    }
}
