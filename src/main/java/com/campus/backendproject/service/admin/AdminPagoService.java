package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminPagoResponse;
import java.util.List;

public interface AdminPagoService {
    List<AdminPagoResponse> listarPagos();
}
