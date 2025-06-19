package com.mss301.carservice.mapper;

import com.mss301.carservice.entities.CarInformation;
import com.mss301.carservice.entities.Manufacturer;
import com.mss301.carservice.entities.Supplier;
import com.mss301.carservice.payload.CarInformationPayload;
import org.springframework.stereotype.Component;

@Component
public class CarInformationMapper {
    public CarInformation toEntity(CarInformationPayload payload, Manufacturer manufacturer, Supplier supplier) {
        CarInformation entity = new CarInformation();
        entity.setCarID(payload.getCarID());
        entity.setCarName(payload.getCarName());
        entity.setCarDescription(payload.getCarDescription());
        entity.setNumberOfDoors(payload.getNumberOfDoors());
        entity.setSeatingCapacity(payload.getSeatingCapacity());
        entity.setFuelType(payload.getFuelType());
        entity.setYear(payload.getYear());
        entity.setManufacturer(manufacturer);
        entity.setSupplier(supplier);
        entity.setCarStatus(payload.getCarStatus());
        entity.setCarRentingPricePerDay(payload.getCarRentingPricePerDay());
        return entity;
    }

    public CarInformationPayload toPayload(CarInformation entity) {
        CarInformationPayload payload = new CarInformationPayload();
        payload.setCarID(entity.getCarID());
        payload.setCarName(entity.getCarName());
        payload.setCarDescription(entity.getCarDescription());
        payload.setNumberOfDoors(entity.getNumberOfDoors());
        payload.setSeatingCapacity(entity.getSeatingCapacity());
        payload.setFuelType(entity.getFuelType());
        payload.setYear(entity.getYear());
        payload.setManufacturerID(entity.getManufacturer() != null ? entity.getManufacturer().getManufacturerID() : null);
        payload.setSupplierID(entity.getSupplier() != null ? entity.getSupplier().getSupplierID() : null);
        payload.setCarStatus(entity.getCarStatus());
        payload.setCarRentingPricePerDay(entity.getCarRentingPricePerDay());
        return payload;
    }
}

