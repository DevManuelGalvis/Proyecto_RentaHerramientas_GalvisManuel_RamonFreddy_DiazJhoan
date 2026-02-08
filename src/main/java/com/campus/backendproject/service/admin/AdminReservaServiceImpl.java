package com.campus.backendproject.service.admin;

import com.campus.backendproject.entity.Reserva;
import com.campus.backendproject.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminReservaServiceImpl implements AdminReservaService {

    private final ReservaRepository repository;

    public AdminReservaServiceImpl(ReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Reserva> listarReservas() {
        return repository.findAll();
    }
}
