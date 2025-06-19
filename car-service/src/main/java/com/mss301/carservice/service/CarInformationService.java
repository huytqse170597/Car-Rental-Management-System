package com.mss301.carservice.service;

import com.mss301.carservice.payload.CarInformationPayload;
import java.util.List;

public interface CarInformationService {
    CarInformationPayload create(CarInformationPayload payload);
    List<CarInformationPayload> getAll();
    CarInformationPayload getById(Long id);
    CarInformationPayload update(Long id, CarInformationPayload payload);
    void delete(Long id);
}

