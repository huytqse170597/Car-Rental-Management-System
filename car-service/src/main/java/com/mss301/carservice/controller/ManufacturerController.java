package com.mss301.carservice.controller;

import com.mss301.carservice.payload.ManufacturerPayload;
import com.mss301.carservice.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<ManufacturerPayload> create(@RequestBody ManufacturerPayload payload) {
        return ResponseEntity.ok(manufacturerService.create(payload));
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerPayload>> getAll() {
        return ResponseEntity.ok(manufacturerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerPayload> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(manufacturerService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerPayload> update(@PathVariable Long id, @RequestBody ManufacturerPayload payload) {
        try {
            return ResponseEntity.ok(manufacturerService.update(id, payload));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        manufacturerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

