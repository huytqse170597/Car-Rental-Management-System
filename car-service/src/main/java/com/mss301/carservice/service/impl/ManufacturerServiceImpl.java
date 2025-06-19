package com.mss301.carservice.service.impl;

import com.mss301.carservice.entities.Manufacturer;
import com.mss301.carservice.mapper.ManufacturerMapper;
import com.mss301.carservice.payload.ManufacturerPayload;
import com.mss301.carservice.repositories.ManufacturerRepository;
import com.mss301.carservice.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper mapper;

    @Override
    public ManufacturerPayload create(ManufacturerPayload payload) {
        Manufacturer entity = mapper.toEntity(payload);
        return mapper.toPayload(manufacturerRepository.save(entity));
    }

    @Override
    public List<ManufacturerPayload> getAll() {
        return manufacturerRepository.findAll().stream()
                .map(mapper::toPayload)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerPayload getById(Long id) {
        return manufacturerRepository.findById(id)
                .map(mapper::toPayload)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
    }

    @Override
    public ManufacturerPayload update(Long id, ManufacturerPayload payload) {
        Manufacturer existing = manufacturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
        Manufacturer updated = mapper.toEntity(payload);
        updated.setManufacturerID(existing.getManufacturerID());
        return mapper.toPayload(manufacturerRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}

