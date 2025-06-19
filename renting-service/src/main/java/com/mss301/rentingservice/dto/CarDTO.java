package com.mss301.rentingservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDTO {
    private Long id;
    private String carName;
    private BigDecimal pricePerDay;
}

