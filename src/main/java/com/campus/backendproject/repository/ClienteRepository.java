package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Cliente;
import com.campus.backendproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByUsuario(Usuario usuario);

    boolean existsByUsuario(Usuario usuario);

    boolean existsByDocumentoIdentidad(String documentoIdentidad);
}