package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminPagoResponse;
import com.campus.backendproject.dto.admin.AdminPagoTableResponse;
import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.enums.EstadoPago;
import com.campus.backendproject.repository.PagoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminPagoServiceImpl implements AdminPagoService {

    private final PagoRepository pagoRepo;

    public AdminPagoServiceImpl(PagoRepository pagoRepo) {
        this.pagoRepo = pagoRepo;
    }

    @Override
    public Page<AdminPagoTableResponse> listarPagos(
            String search,
            EstadoPago estado,
            Pageable pageable
    ) {
        return pagoRepo.listarPagosAdmin(
                search == null || search.isBlank() ? null : search,
                estado,
                pageable
        );
    }

    @Override
    public Map<String, BigDecimal> obtenerTotales() {
        Map<String, BigDecimal> response = new HashMap<>();

        response.put(
                "recaudado",
                pagoRepo.totalPorEstado(EstadoPago.PAGADO)
        );
        response.put(
                "pendiente",
                pagoRepo.totalPorEstado(EstadoPago.PENDIENTE)
        );

        return response;
    }
}
