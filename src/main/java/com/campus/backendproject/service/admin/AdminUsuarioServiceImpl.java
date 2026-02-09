package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.enums.Roles;
import com.campus.backendproject.repository.UsuarioRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsuarioServiceImpl implements AdminUsuarioService {

    private final UsuarioRepository repository;

    public AdminUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<AdminUsuarioResponse> listarUsuarios(
            Roles rol,
            String search,
            Pageable pageable
    ) {
        return repository.findAllWithFilters(rol, search, pageable)
                .map(this::mapToDto);
    }

    @Override
    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }

    private AdminUsuarioResponse mapToDto(Usuario u) {
        return new AdminUsuarioResponse(
                u.getId(),
                u.getNombre(),
                u.getCorreo(),
                u.getDocumento(),
                u.getRol()
        );
    }
}
