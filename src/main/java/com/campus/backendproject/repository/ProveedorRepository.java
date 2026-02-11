package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findByUsuario(Usuario usuario);

}
