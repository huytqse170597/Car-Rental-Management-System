package com.mss301.authservice.controller;

import com.mss301.authservice.entities.Customer;
import com.mss301.authservice.payload.CustomerPayload;
import com.mss301.authservice.service.CustomerService;
import com.mss301.authservice.dto.CustomerProfileUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerPayload> create(@RequestBody CustomerPayload payload) {
        return ResponseEntity.ok(customerService.create(payload));
    }

    @GetMapping
    public ResponseEntity<List<CustomerPayload>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerPayload> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(customerService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<CustomerPayload> getByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(customerService.findByEmail(email));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPayload> update(@PathVariable Long id, @RequestBody CustomerPayload payload) {
        try {
            return ResponseEntity.ok(customerService.update(id, payload));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/profile")
    public ResponseEntity<CustomerPayload> updateProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CustomerProfileUpdateRequest payload) {
        CustomerPayload customer = customerService.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(customerService.updateProfile(customer.getCustomerID(), payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
