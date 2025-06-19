package com.mss301.carservice.payload;

import lombok.Data;

@Data
public class ManufacturerPayload {
    private Long manufacturerID;
    private String manufacturerName;
    private String description;
    private String manufacturerCountry;
}

