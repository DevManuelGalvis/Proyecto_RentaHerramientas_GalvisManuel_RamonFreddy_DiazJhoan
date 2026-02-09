package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminReservaResponse;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.repository.ReservaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AdminReservaServiceImpl implements AdminReservaService {

    private final ReservaRepository reservaRepo;

    public AdminReservaServiceImpl(ReservaRepository reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    @Override
    public Page<AdminReservaResponse> listarReservas(
            EstadoReserva estado,
            String search,
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            int page,
            int size) {

        LocalDateTime desde = fechaDesde != null ? fechaDesde.atStartOfDay() : null;
        LocalDateTime hasta = fechaHasta != null ? fechaHasta.atTime(23, 59, 59, 999_999_999) : null;

        Pageable pageable = PageRequest.of(page, size);

        Page<Reserva> reservasPage = reservaRepo.findAllWithFilters(estado, search, desde, hasta, pageable);

        return reservasPage.map(r -> {
            AdminReservaResponse dto = new AdminReservaResponse();
            dto.setId(r.getId());
            dto.setNombreCliente(r.getCliente() != null && r.getCliente().getUsuario() != null
                    ? r.getCliente().getUsuario().getNombre()
                    : "Desconocido");
            dto.setNombreHerramienta(r.getHerramienta().getNombre());
            dto.setNombreProveedor(r.getHerramienta().getProveedor().getNombreEmpresa());
            dto.setFechaInicio(r.getFechaInicio());
            dto.setFechaFin(r.getFechaFin());
            dto.setEstadoReserva(r.getEstadoReserva().name());
            dto.setDiasAlquiler(ChronoUnit.DAYS.between(r.getFechaInicio(), r.getFechaFin()));
            dto.setTotal(r.getTotal());
            return dto;
        });
    }
}
