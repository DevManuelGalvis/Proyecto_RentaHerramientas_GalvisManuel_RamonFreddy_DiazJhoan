package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminPagoResponse;
import com.campus.backendproject.dto.admin.AdminPagoTableResponse;
import com.campus.backendproject.enums.EstadoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Map;

public interface AdminPagoService {

    Page<AdminPagoTableResponse> listarPagos(
            String search,
            EstadoPago estado,
            Pageable pageable
    );

    public Map<String, BigDecimal> obtenerTotales();
}
