package com.mss301.rentingservice.controller;

import com.mss301.rentingservice.dto.RentingDetailDTO;
import com.mss301.rentingservice.service.RentingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/renting/details")
@RequiredArgsConstructor
public class RentingDetailController {
    private final RentingDetailService service;

    @PostMapping
    public ResponseEntity<RentingDetailDTO> create(@RequestBody RentingDetailDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentingDetailDTO> update(@PathVariable Long id, @RequestBody RentingDetailDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentingDetailDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RentingDetailDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

