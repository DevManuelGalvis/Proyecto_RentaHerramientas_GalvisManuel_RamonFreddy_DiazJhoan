package com.campus.backendproject.security.jwt;

import com.campus.backendproject.security.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtFilter(JwtService jwtService, CustomUserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        // System.out.println("Authorization header: " + header);

        if (header == null || !header.startsWith("Bearer ")) {
            System.out.println("No hay token o formato incorrecto, pasando filtro");
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        // System.out.println("Token recibido: " + token);

        String correo = jwtService.extraerCorreo(token);
       // System.out.println("Correo extraído del token: " + correo);

        if (correo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = userDetailsService.loadUserByUsername(correo);
            // System.out.println("UserDetails cargados: " + user.getUsername());

            if (jwtService.esValido(token)) {
                // System.out.println("Token válido");
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                System.out.println("Token inválido o expirado");
            }
        } else {
            System.out.println("Correo nulo o usuario ya autenticado");
        }

        filterChain.doFilter(request, response);
    }

}
