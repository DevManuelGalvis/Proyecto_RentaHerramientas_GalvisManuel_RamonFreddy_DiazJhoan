package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findByUsuario(Usuario usuario);

    boolean existsByUsuario(Usuario usuario);

    boolean existsByRut(String rut);
}