package com.campus.backendproject.repository;

import com.campus.backendproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    boolean existsByCliente_Usuario_Id(Long usuarioId);
}
