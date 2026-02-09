package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

    @Query("""
        SELECT h
        FROM Herramienta h
        JOIN h.categoriaHerramienta c
        WHERE (:estado IS NULL OR h.estado = :estado)
          AND (:categoriaId IS NULL OR c.id = :categoriaId)
          AND (
                COALESCE(:search, '') = ''
                OR LOWER(h.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
              )
    """)
    Page<Herramienta> findAllWithFilters(
            @Param("estado") EstadoHerramientas estado,
            @Param("categoriaId") Long categoriaId,
            @Param("search") String search,
            Pageable pageable
    );

    boolean existsByNombre(String nombre);
}
