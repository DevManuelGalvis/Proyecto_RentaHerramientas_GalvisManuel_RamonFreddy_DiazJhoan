package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminPagoResponse;
import com.campus.backendproject.repository.PagoRepository;
import com.campus.backendproject.service.admin.AdminPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPagoServiceImpl implements AdminPagoService {

    private final PagoRepository pagoRepo;

    public AdminPagoServiceImpl(PagoRepository pagoRepo) {
        this.pagoRepo = pagoRepo;
    }

    @Override
    public List<AdminPagoResponse> listarPagos() {
        return pagoRepo.findAll().stream().map(p -> {
            AdminPagoResponse dto = new AdminPagoResponse();
            dto.setId(p.getId());
            dto.setMonto(p.getMonto());
            dto.setMetodo(p.getMetodo_pago().name());
            dto.setEstado(p.getEstado_pago().name());
            dto.setFecha(p.getFecha_pago());
            dto.setReservaId(p.getReserva().getId());
            return dto;
        }).toList();
    }
}
