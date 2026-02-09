package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.enums.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
    SELECT u
    FROM Usuario u
    WHERE (:rol IS NULL OR u.rol = :rol)
      AND (
            COALESCE(:search, '') = ''
            OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(u.correo) LIKE LOWER(CONCAT('%', :search, '%'))
          )
""")
    Page<Usuario> findAllWithFilters(
            @Param("rol") Roles rol,
            @Param("search") String search,
            Pageable pageable
    );


    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    boolean existsByDocumento(String documento);
}
