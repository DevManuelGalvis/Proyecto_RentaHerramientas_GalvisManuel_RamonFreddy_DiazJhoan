package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import java.util.List;

public interface AdminUsuarioService {

    List<AdminUsuarioResponse> listarUsuarios();

    void eliminarUsuario(Long id);
}
