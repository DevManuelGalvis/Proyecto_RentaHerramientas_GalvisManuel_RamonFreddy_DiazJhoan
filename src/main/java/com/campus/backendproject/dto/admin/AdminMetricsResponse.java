package com.campus.backendproject.dto.admin;

public class AdminMetricsResponse {

    private Long ingresosTotales;
    private Long reservasActivas;
    private Long totalUsuarios;
    private Long totalHerramientas;
    private Long incidenciasPendientes;

    public AdminMetricsResponse(
            Long ingresosTotales,
            Long reservasActivas,
            Long totalUsuarios,
            Long totalHerramientas,
            Long incidenciasPendientes
    ) {
        this.ingresosTotales = ingresosTotales;
        this.reservasActivas = reservasActivas;
        this.totalUsuarios = totalUsuarios;
        this.totalHerramientas = totalHerramientas;
        this.incidenciasPendientes = incidenciasPendientes;
    }

    public Long getIngresosTotales() {
        return ingresosTotales;
    }

    public Long getReservasActivas() {
        return reservasActivas;
    }

    public Long getTotalUsuarios() {
        return totalUsuarios;
    }

    public Long getTotalHerramientas() {
        return totalHerramientas;
    }

    public Long getIncidenciasPendientes() {
        return incidenciasPendientes;
    }
}
