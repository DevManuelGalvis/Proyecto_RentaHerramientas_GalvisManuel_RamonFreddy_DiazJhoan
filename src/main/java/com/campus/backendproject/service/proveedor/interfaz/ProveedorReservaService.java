package com.campus.backendproject.service.proveedor.interfaz;

import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface ProveedorReservaService {

    Page<ReservaResponse> listarReservasProveedor(
            Long proveedorId,
            EstadoReserva estado,
            LocalDate fecha,
            int page,
            int size
    );

    void aprobarReserva(Long reservaId);

    void rechazarReserva(Long reservaId, String motivo);
}
