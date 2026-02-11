package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.reserva.ReservaResponse;
import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.enums.EstadoReserva;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.ReservaRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorReservaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProveedorReservaServiceImpl implements ProveedorReservaService {

    private final ReservaRepository reservaRepository;

    public ProveedorReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Page<ReservaResponse> listarReservasProveedor(
            Long proveedorId,
            EstadoReserva estado,
            LocalDate fecha,
            int page,
            int size
    ) {

        return reservaRepository
                .findReservasProveedorFiltradas(
                        proveedorId,
                        estado,
                        fecha,
                        PageRequest.of(page, size)
                )
                .map(r -> new ReservaResponse(
                        r.getId(),
                        r.getFechaInicio(),
                        r.getFechaFin(),
                        r.getEstadoReserva(),
                        r.getTotal(),
                        r.getCliente().getUsuario().getNombre(),
                        r.getHerramienta().getNombre(),
                        r.getHerramienta().getId()
                ));
    }

    @Override
    public void aprobarReserva(Long reservaId) {

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RegistroNoEncontradoException("Reserva no encontrada"));

        reserva.setEstadoReserva(EstadoReserva.EN_CURSO);

        reservaRepository.save(reserva);
    }

    @Override
    public void rechazarReserva(Long reservaId, String motivo) {

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RegistroNoEncontradoException("Reserva no encontrada"));

        reserva.setEstadoReserva(EstadoReserva.CANCELADA);

        reservaRepository.save(reserva);
    }

}
