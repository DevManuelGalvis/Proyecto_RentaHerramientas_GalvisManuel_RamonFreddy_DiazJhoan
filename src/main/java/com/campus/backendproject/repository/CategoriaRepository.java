package com.campus.backendproject.repository;

import com.campus.backendproject.entity.CategoriaHerramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaHerramienta, Long> {
}
