package com.mss301.carservice.service;

import com.mss301.carservice.payload.ManufacturerPayload;
import java.util.List;

public interface ManufacturerService {
    ManufacturerPayload create(ManufacturerPayload payload);
    List<ManufacturerPayload> getAll();
    ManufacturerPayload getById(Long id);
    ManufacturerPayload update(Long id, ManufacturerPayload payload);
    void delete(Long id);
}

