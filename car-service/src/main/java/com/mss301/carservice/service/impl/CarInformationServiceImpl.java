package com.mss301.carservice.service.impl;

import com.mss301.carservice.entities.CarInformation;
import com.mss301.carservice.entities.Manufacturer;
import com.mss301.carservice.entities.Supplier;
import com.mss301.carservice.mapper.CarInformationMapper;
import com.mss301.carservice.payload.CarInformationPayload;
import com.mss301.carservice.repositories.CarInformationRepository;
import com.mss301.carservice.repositories.ManufacturerRepository;
import com.mss301.carservice.repositories.SupplierRepository;
import com.mss301.carservice.service.CarInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CarInformationServiceImpl implements CarInformationService {
    private final CarInformationRepository carInformationRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final SupplierRepository supplierRepository;
    private final CarInformationMapper mapper;

    @Override
    public CarInformationPayload create(CarInformationPayload payload) {
        Manufacturer manufacturer = manufacturerRepository.findById(payload.getManufacturerID())
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
        Supplier supplier = supplierRepository.findById(payload.getSupplierID())
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
        CarInformation entity = mapper.toEntity(payload, manufacturer, supplier);
        return mapper.toPayload(carInformationRepository.save(entity));
    }

    @Override
    public List<CarInformationPayload> getAll() {
        return carInformationRepository.findAll().stream()
                .map(mapper::toPayload)
                .collect(Collectors.toList());
    }

    @Override
    public CarInformationPayload getById(Long id) {
        return carInformationRepository.findById(id)
                .map(mapper::toPayload)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }

    @Override
    public CarInformationPayload update(Long id, CarInformationPayload payload) {
        CarInformation existing = carInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
        Manufacturer manufacturer = manufacturerRepository.findById(payload.getManufacturerID())
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
        Supplier supplier = supplierRepository.findById(payload.getSupplierID())
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
        CarInformation updated = mapper.toEntity(payload, manufacturer, supplier);
        updated.setCarID(existing.getCarID());
        return mapper.toPayload(carInformationRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        carInformationRepository.deleteById(id);
    }
}

