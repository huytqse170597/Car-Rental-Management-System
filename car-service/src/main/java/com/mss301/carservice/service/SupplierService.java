package com.mss301.carservice.service;

import com.mss301.carservice.payload.SupplierPayload;
import java.util.List;

public interface SupplierService {
    SupplierPayload create(SupplierPayload payload);
    List<SupplierPayload> getAll();
    SupplierPayload getById(Long id);
    SupplierPayload update(Long id, SupplierPayload payload);
    void delete(Long id);
}

