package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Query("""
SELECT h
FROM Herramienta h
JOIN h.categoriaHerramienta c
WHERE h.proveedor.id = :proveedorId
AND (:estado IS NULL OR h.estado = :estado)
AND (:categoriaId IS NULL OR c.id = :categoriaId)
AND (
    COALESCE(:search,'') = '' 
    OR LOWER(h.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
)
""")
    Page<Herramienta> findByProveedorWithFilters(
            @Param("proveedorId") Long proveedorId,
            @Param("estado") EstadoHerramientas estado,
            @Param("categoriaId") Long categoriaId,
            @Param("search") String search,
            Pageable pageable
    );

    @Query("""
SELECT COUNT(h)
FROM Herramienta h
WHERE h.proveedor.id = :proveedorId
""")
    long countByProveedor(@Param("proveedorId") Long proveedorId);

    @Query("""
SELECT c.nombre, COUNT(h)
FROM Herramienta h
JOIN h.categoriaHerramienta c
WHERE h.proveedor.id = :proveedorId
GROUP BY c.nombre
""")
    List<Object[]> countByCategoriaProveedor(@Param("proveedorId") Long proveedorId);

    @Query("""
SELECT h.estado, COUNT(h)
FROM Herramienta h
WHERE h.proveedor.id = :proveedorId
GROUP BY h.estado
""")
    List<Object[]> countByEstadoProveedor(@Param("proveedorId") Long proveedorId);


    boolean existsByNombre(String nombre);
}
