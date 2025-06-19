package com.mss301.rentingservice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RentingRequest {
    private Long customerId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;
}

