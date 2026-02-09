package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.*;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.enums.EstadoIncidencia;
import com.campus.backendproject.repository.AdminMetricsRepository;
import com.campus.backendproject.repository.AdminRecentRentalRepository;
import com.campus.backendproject.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminMetricsServiceImpl implements AdminMetricsService {

    private final AdminMetricsRepository metricsRepo;
    private final AdminRecentRentalRepository recentRepo;
    private final ReservaRepository reservaRepo; // ⚡ Agregado

    public AdminMetricsServiceImpl(
            AdminMetricsRepository metricsRepo,
            AdminRecentRentalRepository recentRepo,
            ReservaRepository reservaRepo // ⚡ Inyectado
    ) {
        this.metricsRepo = metricsRepo;
        this.recentRepo = recentRepo;
        this.reservaRepo = reservaRepo;
    }

    @Override
    public AdminMetricsResponse obtenerMetricas() {
        Long reservasActivas = metricsRepo.contarPorEstado(EstadoReserva.EN_CURSO);
        Long incidenciasPendientes = metricsRepo.contarIncidenciasPorEstado(EstadoIncidencia.PENDIENTE);

        return new AdminMetricsResponse(
                metricsRepo.totalIngresos(),
                reservasActivas,
                metricsRepo.totalUsuarios(),
                metricsRepo.totalHerramientas(),
                incidenciasPendientes
        );
    }

    @Override
    public List<AdminRecentRentalResponse> obtenerReservasRecientes(int limit) {
        return recentRepo.obtenerReservasRecientes(limit);
    }

    @Override
    public Map<String, Long> obtenerEstadisticasReservas() {
        List<Object[]> datos = metricsRepo.obtenerReservasPorEstado();
        Map<String, Long> estadisticas = new HashMap<>();

        for (Object[] fila : datos) {
            estadisticas.put(fila[0].toString(), (Long) fila[1]);
        }
        return estadisticas;
    }

    @Override
    public List<AdminIngresoMensualResponse> obtenerIngresosMensuales() {
        List<Object[]> resultados = metricsRepo.ingresosPorMes();
        List<AdminIngresoMensualResponse> ingresos = new ArrayList<>();

        for (Object[] fila : resultados) {
            Integer anio = ((Number) fila[0]).intValue();
            Integer mes = ((Number) fila[1]).intValue();
            Long total = ((Number) fila[2]).longValue();

            ingresos.add(new AdminIngresoMensualResponse(anio, mes, total));
        }

        return ingresos;
    }

    @Override
    public List<AdminTopHerramientaResponse> obtenerTopHerramientas() {
        return reservaRepo.findTopHerramientas();
    }
}
