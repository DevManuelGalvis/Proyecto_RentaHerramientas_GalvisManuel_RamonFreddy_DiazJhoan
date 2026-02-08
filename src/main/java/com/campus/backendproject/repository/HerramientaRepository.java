package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Usuario;
import com.campus.backendproject.enums.EstadoHerramientas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

    List<Herramienta> findByEstado(EstadoHerramientas estado);

    List<Herramienta> findByCategoriaHerramienta_Id(Long categoriaId);

    List<Herramienta> findByNombreContainingIgnoreCase(String nombre);

    List<Herramienta> findByEstadoAndCategoriaHerramienta_Id(
            EstadoHerramientas estado,
            Long categoriaId
    );
}


