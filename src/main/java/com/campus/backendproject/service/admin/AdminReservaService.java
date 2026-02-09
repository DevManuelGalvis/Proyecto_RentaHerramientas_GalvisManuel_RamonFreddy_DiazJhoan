package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface AdminReservaService {

    Page<AdminReservaResponse> listarReservas(
            EstadoReserva estado,
            String search,
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            int page,
            int size
    );

}
