package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.entity.Categoria;
import com.campus.backendproject.enums.EstadoHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

    List<Herramienta> findByProveedor(Proveedor proveedor);

    List<Herramienta> findByCategoria(Categoria categoria);

    List<Herramienta> findByDisponibleTrue();

    List<Herramienta> findByCategoriaAndDisponibleTrue(Categoria categoria);

    Optional<Herramienta> findByIdAndDisponibleTrue(Long id);

    List<Herramienta> findByEstado(EstadoHerramienta estado);
}