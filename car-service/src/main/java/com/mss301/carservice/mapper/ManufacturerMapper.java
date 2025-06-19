package com.mss301.carservice.mapper;

import com.mss301.carservice.entities.Manufacturer;
import com.mss301.carservice.payload.ManufacturerPayload;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {
    public Manufacturer toEntity(ManufacturerPayload payload) {
        Manufacturer entity = new Manufacturer();
        entity.setManufacturerID(payload.getManufacturerID());
        entity.setManufacturerName(payload.getManufacturerName());
        entity.setDescription(payload.getDescription());
        entity.setManufacturerCountry(payload.getManufacturerCountry());
        return entity;
    }

    public ManufacturerPayload toPayload(Manufacturer entity) {
        ManufacturerPayload payload = new ManufacturerPayload();
        payload.setManufacturerID(entity.getManufacturerID());
        payload.setManufacturerName(entity.getManufacturerName());
        payload.setDescription(entity.getDescription());
        payload.setManufacturerCountry(entity.getManufacturerCountry());
        return payload;
    }
}

