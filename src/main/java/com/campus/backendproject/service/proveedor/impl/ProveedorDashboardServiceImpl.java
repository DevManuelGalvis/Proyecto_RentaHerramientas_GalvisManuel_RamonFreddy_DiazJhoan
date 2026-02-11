package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.proveedor.ProveedorDashboardStatsResponse;
import com.campus.backendproject.dto.proveedor.TopHerramientaResponse;
import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.repository.PagoRepository;
import com.campus.backendproject.repository.ReservaRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorDashboardService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProveedorDashboardServiceImpl implements ProveedorDashboardService {

    private final HerramientaRepository herramientaRepository;
    private final ReservaRepository reservaRepository;
    private final PagoRepository pagoRepository;

    public ProveedorDashboardServiceImpl(
            HerramientaRepository herramientaRepository,
            ReservaRepository reservaRepository,
            PagoRepository pagoRepository) {

        this.herramientaRepository = herramientaRepository;
        this.reservaRepository = reservaRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public ProveedorDashboardStatsResponse obtenerEstadisticas(Long proveedorId) {

        long totalHerramientas =
                herramientaRepository.countByProveedor(proveedorId);

        long reservasPendientes =
                reservaRepository.countByProveedorAndEstado(
                        proveedorId,
                        EstadoReserva.RESERVADA
                );

        long rentasActivas =
                reservaRepository.countByProveedorAndEstado(
                        proveedorId,
                        EstadoReserva.EN_CURSO
                );

        LocalDate hoy = LocalDate.now();

        var ingresosMensuales =
                pagoRepository.ingresosMensuales(
                        proveedorId,
                        hoy.getMonthValue(),
                        hoy.getYear()
                );

        return new ProveedorDashboardStatsResponse(
                totalHerramientas,
                reservasPendientes,
                rentasActivas,
                ingresosMensuales
        );
    }

    @Override
    public List<ReservaResponse> obtenerReservasRecientes(Long proveedorId, int limit) {

        return reservaRepository
                .findByProveedorRecientes(proveedorId, PageRequest.of(0, limit))
                .getContent()
                .stream()
                .map(r -> new ReservaResponse(
                        r.getId(),
                        r.getFechaInicio(),
                        r.getFechaFin(),
                        r.getEstadoReserva(),
                        r.getTotal(),
                        r.getCliente().getUsuario().getNombre(),
                        r.getHerramienta().getNombre(),
                        r.getHerramienta().getId()
                ))
                .toList();
    }


    @Override
    public List<TopHerramientaResponse> obtenerTopHerramientas(Long proveedorId, int limit) {

        return reservaRepository
                .findTopHerramientasProveedor(proveedorId, PageRequest.of(0, limit))
                .getContent();
    }
}
