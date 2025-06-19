package com.mss301.authservice.service.impl;

import com.mss301.authservice.dto.CustomerProfileUpdateRequest;
import com.mss301.authservice.entities.Customer;
import com.mss301.authservice.mapper.CustomerMapper;
import com.mss301.authservice.payload.CustomerPayload;
import com.mss301.authservice.repositories.CustomerRepository;
import com.mss301.authservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerPayload create(CustomerPayload payload) {
        Customer entity = mapper.toEntity(payload);
        entity.setPassword(passwordEncoder.encode(payload.getPassword()));
        return mapper.toPayload(customerRepository.save(entity));
    }

    @Override
    public List<CustomerPayload> getAll() {
        return customerRepository.findAll().stream()
                .map(mapper::toPayload)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerPayload getById(Long id) {
        return customerRepository.findById(id)
                .map(mapper::toPayload)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public CustomerPayload findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .map(mapper::toPayload)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public CustomerPayload update(Long id, CustomerPayload payload) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Customer updated = mapper.toEntity(payload);
        updated.setCustomerID(existing.getCustomerID());
        return mapper.toPayload(customerRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerPayload updateProfile(Long id, CustomerProfileUpdateRequest payload) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        existing.setCustomerName(payload.getCustomerName());
        existing.setTelephone(payload.getTelephone());
        return mapper.toPayload(customerRepository.save(existing));
    }
}
