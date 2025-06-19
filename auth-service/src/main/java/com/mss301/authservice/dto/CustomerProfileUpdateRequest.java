package com.mss301.authservice.dto;

import lombok.Data;

@Data
public class CustomerProfileUpdateRequest {
    private String customerName;
    private String telephone;
}

