package com.campus.backendproject.service.admin;

import com.campus.backendproject.entity.Pago;
import com.campus.backendproject.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPagoServiceImpl implements AdminPagoService {

    private final PagoRepository repository;

    public AdminPagoServiceImpl(PagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pago> listarPagos() {
        return repository.findAll();
    }
}
