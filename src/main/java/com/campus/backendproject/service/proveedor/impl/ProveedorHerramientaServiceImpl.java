package com.campus.backendproject.service.proveedor.impl;

import com.campus.backendproject.dto.herramienta.HerramientaRequest;
import com.campus.backendproject.dto.herramienta.HerramientaResponse;
import com.campus.backendproject.entity.CategoriaHerramienta;
import com.campus.backendproject.entity.Herramienta;
import com.campus.backendproject.entity.Proveedor;
import com.campus.backendproject.exception.BusinessRuleException;
import com.campus.backendproject.exception.ConflictDbException;
import com.campus.backendproject.exception.RegistroNoEncontradoException;
import com.campus.backendproject.repository.CategoriaRepository;
import com.campus.backendproject.repository.HerramientaRepository;
import com.campus.backendproject.repository.ProveedorRepository;
import com.campus.backendproject.service.proveedor.interfaz.ProveedorHerramientaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProveedorHerramientaServiceImpl implements ProveedorHerramientaService {

    private final HerramientaRepository herramientaRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;

    public ProveedorHerramientaServiceImpl(HerramientaRepository herramientaRepository, CategoriaRepository categoriaRepository, ProveedorRepository proveedorRepository) {
        this.herramientaRepository = herramientaRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
    }
    @Override
    public HerramientaResponse crearHerramienta(HerramientaRequest herramientaRequest) {
        boolean existHerramientaConNombre = herramientaRepository.existsByNombre(herramientaRequest.getNombre());
        if(existHerramientaConNombre){
            throw new ConflictDbException("Error ya existe esa herramienta con el mismo nombre");
        }

        CategoriaHerramienta categoria = categoriaRepository.findById(herramientaRequest.getCategoriaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No se pudo crear la herramienta, " +
                                "porque la categoria con el id " + herramientaRequest.getCategoriaId() + " no existe"));

        Proveedor proveedor = proveedorRepository.findById(herramientaRequest.getProveedorId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No se pudo crear la herramienta, " +
                        "porque el proveedor con id " + herramientaRequest.getProveedorId() + " no existe" ));

        if(herramientaRequest.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("El precio de la herramienta debe ser mayor a 0");
        }

        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(herramientaRequest.getNombre());
        herramienta.setDescripcion(herramientaRequest.getDescripcion());
        herramienta.setPrecio(herramientaRequest.getPrecio());
        herramienta.setEstado(herramientaRequest.getEstado());
        herramienta.setCategoriaHerramienta(categoria);
        herramienta.setProveedor(proveedor);

        Herramienta creada = herramientaRepository.save(herramienta);

        return convertirResponse(creada);
    }

    @Override
    public void eliminarHerramienta(Long id) {
        if(!herramientaRepository.existsById(id)){
            throw new RegistroNoEncontradoException("No se encontro la herramienta con el id " + id);
        }
        herramientaRepository.deleteById(id);
    }

    @Override
    public HerramientaResponse actualizarHerramienta(Long id,HerramientaRequest herramientaRequest) {
        Herramienta herramientaExistente = herramientaRepository.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No se pudo actualizar porque no se encontro la herramienta con el id " + id));

        if(herramientaExistente.getNombre().equalsIgnoreCase(herramientaRequest.getNombre()) &&
            herramientaRepository.existsByNombre(herramientaRequest.getNombre())){
            throw new ConflictDbException("Error: El nombre '" + herramientaRequest.getNombre() + "' ya existe en el sistema");
        }

        CategoriaHerramienta categoria = categoriaRepository.findById(herramientaRequest.getCategoriaId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No se pudo actualizar la herramienta, " +
                        "porque la categoria con id " + herramientaRequest.getCategoriaId() + " no existe"));

        Proveedor proveedor = proveedorRepository.findById(herramientaRequest.getProveedorId())
                .orElseThrow(() -> new RegistroNoEncontradoException("No se pudo actualizar la herramienta, " +
                        "porque el proveedor con id " + herramientaRequest.getProveedorId() + " no existe" ));

        if(herramientaRequest.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("El precio actualizado de la herramienta debe ser mayor a 0");
        }

        herramientaExistente.setNombre(herramientaRequest.getNombre());
        herramientaExistente.setDescripcion(herramientaRequest.getDescripcion());
        herramientaExistente.setPrecio(herramientaRequest.getPrecio());
        herramientaExistente.setEstado(herramientaRequest.getEstado());
        herramientaExistente.setCategoriaHerramienta(categoria);
        herramientaExistente.setProveedor(proveedor);

        Herramienta actualizado = herramientaRepository.save(herramientaExistente);

        return convertirResponse(actualizado);
    }

    public HerramientaResponse convertirResponse(Herramienta herramienta) {
        return new HerramientaResponse(
                herramienta.getId(),
                herramienta.getNombre(),
                herramienta.getDescripcion(),
                herramienta.getPrecio(),
                herramienta.getEstado(),
                herramienta.getCategoriaHerramienta() != null ? herramienta.getCategoriaHerramienta().getNombre() : "Sin Categoría",
                herramienta.getProveedor() != null ? herramienta.getProveedor().getNombreEmpresa() : "Sin Proveedor",
                herramienta.getImagenesHerramientas() != null ? herramienta.getImagenesHerramientas().getUrlImagen() : "sin-imagen.png"
        );
    }
}
