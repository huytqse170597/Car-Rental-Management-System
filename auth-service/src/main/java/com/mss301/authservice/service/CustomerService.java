package com.mss301.authservice.service;

import com.mss301.authservice.dto.CustomerProfileUpdateRequest;
import com.mss301.authservice.payload.CustomerPayload;
import java.util.List;

public interface CustomerService {
    CustomerPayload create(CustomerPayload payload);
    List<CustomerPayload> getAll();
    CustomerPayload getById(Long id);
    CustomerPayload findByEmail(String email);
    CustomerPayload update(Long id, CustomerPayload payload);
    void delete(Long id);
    CustomerPayload updateProfile(Long id, CustomerProfileUpdateRequest payload);
}
