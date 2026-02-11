package com.campus.backendproject.service.seguridad.impl;

import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.repository.ProveedorRepository;
import com.campus.backendproject.repository.UsuarioRepository;
import com.campus.backendproject.service.seguridad.interfaz.SeguridadService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SeguridadServiceImpl implements SeguridadService {

    private final UsuarioRepository usuarioRepository;
    private final ProveedorRepository proveedorRepository;

    public SeguridadServiceImpl(
            UsuarioRepository usuarioRepository,
            ProveedorRepository proveedorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Long obtenerProveedorIdLogueado() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        Usuario usuario = usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new RuntimeException("Usuario no autenticado"));

        return proveedorRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Proveedor no asociado"))
                .getId();
    }
}
