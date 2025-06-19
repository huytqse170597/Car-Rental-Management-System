package com.mss301.carservice.controller;

import com.mss301.carservice.payload.SupplierPayload;
import com.mss301.carservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierPayload> create(@RequestBody SupplierPayload payload) {
        return ResponseEntity.ok(supplierService.create(payload));
    }

    @GetMapping
    public ResponseEntity<List<SupplierPayload>> getAll() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierPayload> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(supplierService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierPayload> update(@PathVariable Long id, @RequestBody SupplierPayload payload) {
        try {
            return ResponseEntity.ok(supplierService.update(id, payload));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

