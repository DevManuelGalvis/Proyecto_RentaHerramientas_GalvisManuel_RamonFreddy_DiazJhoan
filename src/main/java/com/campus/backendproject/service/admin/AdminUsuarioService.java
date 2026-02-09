package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import com.campus.backendproject.enums.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminUsuarioService {

    Page<AdminUsuarioResponse> listarUsuarios(
            Roles rol,
            String search,
            Pageable pageable
    );

    void eliminarUsuario(Long id);
}
