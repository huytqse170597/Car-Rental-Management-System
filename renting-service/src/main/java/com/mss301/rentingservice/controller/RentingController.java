package com.mss301.rentingservice.controller;

import com.mss301.rentingservice.client.AuthServiceClient;
import com.mss301.rentingservice.dto.CustomerDTO;
import com.mss301.rentingservice.dto.RentingRequest;
import com.mss301.rentingservice.dto.RentingTransactionDTO;
import com.mss301.rentingservice.entities.RentingTransaction;
import com.mss301.rentingservice.service.RentingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/renting")
@RequiredArgsConstructor
public class RentingController {

    private final RentingService rentingService;
    private final AuthServiceClient authServiceClient;

    @PostMapping
    public ResponseEntity<RentingTransactionDTO> createRenting(@RequestBody RentingRequest request) {
        return ResponseEntity.ok(rentingService.createRenting(request));
    }

    @GetMapping("/history")
    public ResponseEntity<List<RentingTransactionDTO>> getHistory(@AuthenticationPrincipal UserDetails userDetails) {
        CustomerDTO customer = authServiceClient.getCustomerByEmail(userDetails.getUsername());
        return ResponseEntity.ok(rentingService.getHistoryForCustomer(customer.getCustomerID()));
    }

    @GetMapping("/report")
    public ResponseEntity<List<RentingTransactionDTO>> getReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(rentingService.getReport(startDate, endDate));
    }

    @GetMapping("/test")
    public String test() {
        return "Renting service is up!";
    }
}
