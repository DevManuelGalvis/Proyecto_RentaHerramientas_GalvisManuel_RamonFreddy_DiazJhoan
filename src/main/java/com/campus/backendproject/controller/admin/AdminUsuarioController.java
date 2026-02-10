package com.campus.backendproject.controller.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.enums.Roles;
import com.campus.backendproject.service.admin.AdminUsuarioService;
import com.campus.backendproject.service.admin.AdminUsuarioServiceImpl;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

    private final  AdminUsuarioService service;;

    public AdminUsuarioController(AdminUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public Page<AdminUsuarioResponse> listar(
            @RequestParam(required = false) Roles rol,
            @RequestParam(required = false, defaultValue = "") String search,
            @ParameterObject Pageable pageable
    ) {
        return service.listarUsuarios(rol, search, pageable);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }
}

