package com.campus.backendproject.dto.proveedor;

import java.math.BigDecimal;

public class ProveedorDashboardStatsResponse {

    private long totalHerramientas;
    private long reservasPendientes;
    private long rentasActivas;
    private BigDecimal ingresosMensuales;

    public ProveedorDashboardStatsResponse(
            long totalHerramientas,
            long reservasPendientes,
            long rentasActivas,
            BigDecimal ingresosMensuales) {

        this.totalHerramientas = totalHerramientas;
        this.reservasPendientes = reservasPendientes;
        this.rentasActivas = rentasActivas;
        this.ingresosMensuales = ingresosMensuales;
    }

    public long getTotalHerramientas() {
        return totalHerramientas;
    }

    public long getReservasPendientes() {
        return reservasPendientes;
    }

    public long getRentasActivas() {
        return rentasActivas;
    }

    public BigDecimal getIngresosMensuales() {
        return ingresosMensuales;
    }
}
