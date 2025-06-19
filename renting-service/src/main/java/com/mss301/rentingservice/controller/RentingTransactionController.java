package com.mss301.rentingservice.controller;

import com.mss301.rentingservice.dto.RentingTransactionDTO;
import com.mss301.rentingservice.service.RentingTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/renting/transactions")
@RequiredArgsConstructor
public class RentingTransactionController {
    private final RentingTransactionService service;

    @PostMapping
    public ResponseEntity<RentingTransactionDTO> create(@RequestBody RentingTransactionDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentingTransactionDTO> update(@PathVariable Long id, @RequestBody RentingTransactionDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentingTransactionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RentingTransactionDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

