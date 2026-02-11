package com.campus.backendproject.controller;

import com.campus.backendproject.dto.login.LoginRequest;
import com.campus.backendproject.dto.usuario.UsuarioRequest;
import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.enums.Roles;
import com.campus.backendproject.repository.UsuarioRepository;
import com.campus.backendproject.security.jwt.JwtService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthController(
            UsuarioRepository usuarioRepo,
            PasswordEncoder encoder,
            AuthenticationManager authManager,
            JwtService jwtService
    ) {
        this.usuarioRepo = usuarioRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid UsuarioRequest dto) {

        if (usuarioRepo.existsByCorreo(dto.getCorreo())) {
            throw new RuntimeException("Correo ya registrado");
        }

        if (dto.getRol() == Roles.CLIENTE || dto.getRol() == Roles.PROVEEDOR) {
            if (dto.getTelefono() == null || dto.getDireccion() == null) {
                throw new RuntimeException("Teléfono y dirección son obligatorios");
            }
        }

        if (dto.getRol() == Roles.PROVEEDOR && dto.getNombreEmpresa() == null) {
            throw new RuntimeException("Nombre de empresa es obligatorio para proveedor");
        }

        Usuario usuario = new Usuario(
                dto.getNombre(),
                dto.getCorreo(),
                dto.getDocumento(),
                encoder.encode(dto.getPassword()),
                dto.getRol()
        );

        if (dto.getRol() == Roles.CLIENTE) {

            Cliente cliente = new Cliente(
                    dto.getTelefono(),
                    dto.getDireccion(),
                    usuario
            );

            usuario.setCliente(cliente);
        }

        if (dto.getRol() == Roles.PROVEEDOR) {

            Proveedor proveedor = new Proveedor(
                    dto.getNombreEmpresa(),
                    dto.getTelefono(),
                    dto.getDireccion(),
                    usuario
            );

            usuario.setProveedor(proveedor);
        }

        usuarioRepo.save(usuario);

        return Map.of("mensaje", "Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCorreo(),
                        request.getPassword()
                )
        );

        Usuario usuario = usuarioRepo
                .findByCorreo(request.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generarToken(usuario);


        return Map.of("token", token);
    }
}
