package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.entity.CategoriaHerramienta;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.enums.EstadoHerramientas;
import com.campus.backendproject.exception.BusinessRuleException;
import com.campus.backendproject.exception.ConflictDbException;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.CategoriaRepository;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.repository.ProveedorRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorHerramientaService;
import com.campus.backendproject.service.seguridad.interfaz.SeguridadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProveedorHerramientaServiceImpl implements ProveedorHerramientaService {

    private final HerramientaRepository herramientaRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;
    private final SeguridadService seguridadService;

    public ProveedorHerramientaServiceImpl(
            HerramientaRepository herramientaRepository,
            CategoriaRepository categoriaRepository,
            ProveedorRepository proveedorRepository,
            SeguridadService seguridadService
    ) {
        this.herramientaRepository = herramientaRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
        this.seguridadService = seguridadService;
    }

    // ✅ Crear herramienta (proveedor logueado)
    @Override
    public HerramientaResponse crearHerramienta(HerramientaRequest request) {

        if (herramientaRepository.existsByNombre(request.getNombre())) {
            throw new ConflictDbException("Ya existe una herramienta con ese nombre");
        }

        CategoriaHerramienta categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("Categoría no encontrada"));

        Long proveedorId = seguridadService.obtenerProveedorIdLogueado();

        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new RegistroNoEncontradoException("Proveedor no encontrado"));

        if (request.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("El precio debe ser mayor a 0");
        }

        if (request.getStock() == null || request.getStock() < 0) {
            throw new BusinessRuleException("El stock no puede ser negativo");
        }

        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(request.getNombre());
        herramienta.setDescripcion(request.getDescripcion());
        herramienta.setPrecio(request.getPrecio());
        herramienta.setEstado(request.getEstado());
        herramienta.setStock(request.getStock());
        herramienta.setCategoriaHerramienta(categoria);
        herramienta.setProveedor(proveedor);

        return convertirResponse(
                herramientaRepository.save(herramienta)
        );
    }

    // ✅ Actualizar herramienta
    @Override
    public HerramientaResponse actualizarHerramienta(Long id, HerramientaRequest request) {

        Herramienta herramienta = herramientaRepository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("Herramienta no encontrada"));

        if (!herramienta.getNombre().equalsIgnoreCase(request.getNombre())
                && herramientaRepository.existsByNombre(request.getNombre())) {
            throw new ConflictDbException("Ese nombre ya existe");
        }

        CategoriaHerramienta categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("Categoría no encontrada"));

        if (request.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("El precio debe ser mayor a 0");
        }

        herramienta.setNombre(request.getNombre());
        herramienta.setDescripcion(request.getDescripcion());
        herramienta.setPrecio(request.getPrecio());
        herramienta.setEstado(request.getEstado());
        herramienta.setStock(request.getStock());
        herramienta.setCategoriaHerramienta(categoria);

        return convertirResponse(
                herramientaRepository.save(herramienta)
        );
    }

    // ✅ Eliminar herramienta
    @Override
    public void eliminarHerramienta(Long id) {

        if (!herramientaRepository.existsById(id)) {
            throw new RegistroNoEncontradoException("Herramienta no encontrada");
        }

        herramientaRepository.deleteById(id);
    }

    // 📊 Listar herramientas del proveedor con filtros
    @Override
    public Page<HerramientaResponse> listarPorProveedor(
            Long proveedorId,
            String search,
            Long categoriaId,
            EstadoHerramientas estado,
            Pageable pageable
    ) {
        return herramientaRepository
                .findByProveedorWithFilters(proveedorId, estado, categoriaId, search, pageable)
                .map(this::convertirResponse);
    }

    // 🔁 Mapper DTO
    private HerramientaResponse convertirResponse(Herramienta h) {

        return new HerramientaResponse(
                h.getId(),
                h.getNombre(),
                h.getDescripcion(),
                h.getPrecio(),
                h.getEstado(),
                h.getStock(),
                h.getCategoriaHerramienta() != null
                        ? h.getCategoriaHerramienta().getNombre()
                        : "Sin categoría",
                h.getProveedor() != null
                        ? h.getProveedor().getNombreEmpresa()
                        : "Sin proveedor",
                h.getImagenesHerramientas() != null
                        ? h.getImagenesHerramientas().getUrlImagen()
                        : "sin-imagen.png"
        );
    }
}
