package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.service.admin.AdminUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

    private final AdminUsuarioService service;

    public AdminUsuarioController(AdminUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<AdminUsuarioResponse> listar() {
        return service.listarUsuarios();
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }
}
