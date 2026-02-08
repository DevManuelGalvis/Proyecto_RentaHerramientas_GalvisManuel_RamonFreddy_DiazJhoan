package com.campus.backendproject.service.admin;

import com.campus.backendproject.dto.admin.AdminUsuarioResponse;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.exception.BusinessRuleException;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.exception.ResourceNotAvailableException;
import com.campus.backendproject.repository.ReservaRepository;
import com.campus.backendproject.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsuarioServiceImpl implements AdminUsuarioService {

    private final UsuarioRepository repository;
    private final ReservaRepository reservaRepository;

    public AdminUsuarioServiceImpl(UsuarioRepository repository,  ReservaRepository reservaRepository) {
        this.repository = repository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<AdminUsuarioResponse> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        if(usuarios.isEmpty()){
            throw new ResourceNotAvailableException("No hay usuarios registrados en la base de datos.");
        }
        return usuarios.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void eliminarUsuario(Long id) {
        if(!repository.existsById(id)){
            throw new RegistroNoEncontradoException("No se puede eliminar el usuario con el id " + id + " porque no existe.");
        }

        boolean tieneReservasActivas = reservaRepository.existsByCliente_Usuario_Id(id);

        if(tieneReservasActivas){
            throw new BusinessRuleException("No se puede eliminar el usuario con el id " + id + " porque tiene reservas activas.");
        }
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
