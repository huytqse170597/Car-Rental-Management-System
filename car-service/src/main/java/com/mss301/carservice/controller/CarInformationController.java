package com.mss301.carservice.controller;

import com.mss301.carservice.entities.CarInformation;
import com.mss301.carservice.payload.CarInformationPayload;
import com.mss301.carservice.service.CarInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarInformationController {
    private final CarInformationService carInformationService;

    @PostMapping
    public ResponseEntity<CarInformationPayload> create(@RequestBody CarInformationPayload payload) {
        return ResponseEntity.ok(carInformationService.create(payload));
    }

    @GetMapping
    public ResponseEntity<List<CarInformationPayload>> getAll() {
        return ResponseEntity.ok(carInformationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarInformationPayload> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(carInformationService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarInformationPayload> update(@PathVariable Long id, @RequestBody CarInformationPayload payload) {
        try {
            return ResponseEntity.ok(carInformationService.update(id, payload));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carInformationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
