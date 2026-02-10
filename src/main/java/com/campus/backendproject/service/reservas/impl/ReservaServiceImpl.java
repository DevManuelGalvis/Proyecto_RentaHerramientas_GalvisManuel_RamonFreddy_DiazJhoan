package com.campus.backendproject.service.reservas.impl;

import com.campus.backendproject.dto.reserva.ReservaRequest;
import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.exception.BusinessRuleException;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.exception.ResourceNotAvailableException;
import com.campus.backendproject.repository.ClienteRepository;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.repository.ReservaRepository;
import com.campus.backendproject.service.reservas.interfaz.ReservaService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final HerramientaRepository herramientaRepository;
    private final ClienteRepository clienteRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository,
                              HerramientaRepository herramientaRepository,
                              ClienteRepository clienteRepository) {
        this.reservaRepository = reservaRepository;
        this.herramientaRepository = herramientaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public ReservaResponse crearReserva(ReservaRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RegistroNoEncontradoException("Cliente no encontrado"));

        Herramienta herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("Herramienta no encontrada"));

        if (request.getFechaFin().isBefore(request.getFechaInicio())) {
            throw new BusinessRuleException("La fecha de fin no puede ser anterior a la de inicio");
        }

        long ocupadas = reservaRepository.countReservasActivasEnRango(
                herramienta.getId(), request.getFechaInicio(), request.getFechaFin());

        if (ocupadas >= herramienta.getStock()) {
            throw new ResourceNotAvailableException("No hay unidades disponibles para '" +
                    herramienta.getNombre() + "'. Stock: " + herramienta.getStock());
        }

        long dias = Duration.between(request.getFechaInicio(), request.getFechaFin()).toDays();
        if (dias <= 0) dias = 1;
        BigDecimal total = herramienta.getPrecio().multiply(new BigDecimal(dias));

        Reserva reserva = new Reserva();
        reserva.setFechaInicio(request.getFechaInicio());
        reserva.setFechaFin(request.getFechaFin());
        reserva.setCliente(cliente);
        reserva.setHerramienta(herramienta);
        reserva.setTotal(total);
        reserva.setEstadoReserva(EstadoReserva.RESERVADA);

        return mapToResponse(reservaRepository.save(reserva));
    }

    @Override
    @Transactional()
    public Page<ReservaResponse> listarConFiltros(
            EstadoReserva estado, String search, LocalDate fechaDesde, LocalDate fechaHasta, int page, int size) {

        LocalDateTime desde = fechaDesde != null ? fechaDesde.atStartOfDay() : null;
        LocalDateTime hasta = fechaHasta != null ? fechaHasta.atTime(23, 59, 59, 999_999_999) : null;

        Pageable pageable = PageRequest.of(page, size);

        return reservaRepository.findAllWithFilters(estado, search, desde, hasta, pageable)
                .map(this::mapToResponse);
    }

    @Override
    @Transactional()
    public ReservaResponse obtenerPorId(Long id) {
        Reserva r = reservaRepository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("Reserva no encontrada"));
        return mapToResponse(r);
    }

    @Override
    @Transactional
    public void completarDevolucion(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RegistroNoEncontradoException("Reserva no encontrada"));

        reserva.setEstadoReserva(EstadoReserva.DEVUELTA);
        reservaRepository.save(reserva);
    }

    @Override
    @Transactional
    public void cancelarReserva(Long id) {
        Reserva r = reservaRepository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("Reserva no encontrada"));
        r.setEstadoReserva(EstadoReserva.CANCELADA);
        reservaRepository.save(r);
    }

    private ReservaResponse mapToResponse(Reserva r) {
        return new ReservaResponse(
                r.getId(),
                r.getFechaInicio(),
                r.getFechaFin(),
                r.getEstadoReserva(),
                r.getTotal(),
                (r.getCliente() != null && r.getCliente().getUsuario() != null) ? r.getCliente().getUsuario().getNombre() : "Desconocido",
                r.getHerramienta().getNombre(),
                r.getHerramienta().getId()
        );
    }
}