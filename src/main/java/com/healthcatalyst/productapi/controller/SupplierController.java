package com.healthcatalyst.productapi.controller;

import com.healthcatalyst.productapi.entity.Supplier;
import com.healthcatalyst.productapi.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepository repository;

    @GetMapping
    public List<Supplier> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return repository.save(supplier);
    }

    @PutMapping("/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier) {
        supplier.setId(id);
        return repository.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
