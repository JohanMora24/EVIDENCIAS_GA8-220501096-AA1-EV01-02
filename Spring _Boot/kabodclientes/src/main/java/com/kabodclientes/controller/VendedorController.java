package com.kabodclientes.controller;

import com.kabodclientes.model.Vendedor;
import com.kabodclientes.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin(origins = "*")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Crear un nuevo vendedor
    @PostMapping
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    // Obtener todos los vendedores
    @GetMapping
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorRepository.findAll();
    }

    // Obtener vendedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> obtenerVendedorPorId(@PathVariable("id") Integer id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        if (vendedor.isPresent()) {
            return ResponseEntity.ok(vendedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un vendedor
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> actualizarVendedor(@PathVariable("id") Integer id, @RequestBody Vendedor vendedorActualizado) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isPresent()) {
            Vendedor vendedorExistente = vendedorOptional.get();
            vendedorExistente.setNombreVendedor(vendedorActualizado.getNombreVendedor());
            vendedorExistente.setTelefonoVendedor(vendedorActualizado.getTelefonoVendedor());
            vendedorExistente.setEmailVendedor(vendedorActualizado.getEmailVendedor());

            Vendedor actualizado = vendedorRepository.save(vendedorExistente);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVendedor(@PathVariable("id") Integer id) {
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

