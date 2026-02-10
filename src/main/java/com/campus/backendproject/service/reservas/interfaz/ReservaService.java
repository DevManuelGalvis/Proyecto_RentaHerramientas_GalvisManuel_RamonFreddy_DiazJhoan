package com.campus.backendproject.service.reservas.interfaz;

import com.campus.backendproject.dto.reserva.ReservaRequest;
import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface ReservaService {

    ReservaResponse crearReserva(ReservaRequest request);
    ReservaResponse obtenerPorId(Long id);
    void cancelarReserva(Long id);
    void completarDevolucion(Long reservaId);
    Page<ReservaResponse> listarConFiltros(
            EstadoReserva estado,
            String search,
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            int page,
            int size
    );
}