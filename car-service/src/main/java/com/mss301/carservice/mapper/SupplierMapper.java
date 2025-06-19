package com.mss301.carservice.mapper;

import com.mss301.carservice.entities.Supplier;
import com.mss301.carservice.payload.SupplierPayload;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public Supplier toEntity(SupplierPayload payload) {
        Supplier entity = new Supplier();
        entity.setSupplierID(payload.getSupplierID());
        entity.setSupplierName(payload.getSupplierName());
        entity.setSupplierDescription(payload.getSupplierDescription());
        entity.setSupplierAddress(payload.getSupplierAddress());
        return entity;
    }

    public SupplierPayload toPayload(Supplier entity) {
        SupplierPayload payload = new SupplierPayload();
        payload.setSupplierID(entity.getSupplierID());
        payload.setSupplierName(entity.getSupplierName());
        payload.setSupplierDescription(entity.getSupplierDescription());
        payload.setSupplierAddress(entity.getSupplierAddress());
        return payload;
    }
}

