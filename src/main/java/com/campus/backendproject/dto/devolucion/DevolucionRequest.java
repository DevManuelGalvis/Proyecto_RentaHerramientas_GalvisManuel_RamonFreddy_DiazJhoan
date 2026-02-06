package com.campus.backendproject.dto.devolucion;

import com.campus.backendproject.enums.EstadoDevolucion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DevolucionRequest {

    @NotNull(message = "El ID de la reserva es obligatorio para procesar la devolucion")
    private Long reservaId;

    @NotNull(message = "Debe registrar el estado en el que se recibe el equipo")
    private EstadoDevolucion estadoDevolucion;

    @NotBlank(message = "Las observaciones son obligatorias (indique si hubo novedades o todo esta conforme)")
    @Size(max = 500, message = "Las observaciones no pueden superar los 500 caracteres")
    private String observaciones;

    public DevolucionRequest() {}

    public DevolucionRequest(Long reservaId, EstadoDevolucion estadoDevolucion, String observaciones) {
        this.reservaId = reservaId;
        this.estadoDevolucion = estadoDevolucion;
        this.observaciones = observaciones;
    }

    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }

    public EstadoDevolucion getEstadoDevolucion() { return estadoDevolucion; }
    public void setEstadoDevolucion(EstadoDevolucion estadoDevolucion) { this.estadoDevolucion = estadoDevolucion; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
