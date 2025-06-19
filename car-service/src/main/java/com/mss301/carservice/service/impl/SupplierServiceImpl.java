package com.mss301.carservice.service.impl;

import com.mss301.carservice.entities.Supplier;
import com.mss301.carservice.mapper.SupplierMapper;
import com.mss301.carservice.payload.SupplierPayload;
import com.mss301.carservice.repositories.SupplierRepository;
import com.mss301.carservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper mapper;

    @Override
    public SupplierPayload create(SupplierPayload payload) {
        Supplier entity = mapper.toEntity(payload);
        return mapper.toPayload(supplierRepository.save(entity));
    }

    @Override
    public List<SupplierPayload> getAll() {
        return supplierRepository.findAll().stream()
                .map(mapper::toPayload)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierPayload getById(Long id) {
        return supplierRepository.findById(id)
                .map(mapper::toPayload)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
    }

    @Override
    public SupplierPayload update(Long id, SupplierPayload payload) {
        Supplier existing = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
        Supplier updated = mapper.toEntity(payload);
        updated.setSupplierID(existing.getSupplierID());
        return mapper.toPayload(supplierRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}

