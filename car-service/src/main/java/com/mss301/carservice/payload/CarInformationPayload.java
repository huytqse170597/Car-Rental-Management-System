package com.mss301.carservice.payload;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CarInformationPayload {
    private Long carID;
    private String carName;
    private String carDescription;
    private Integer numberOfDoors;
    private Integer seatingCapacity;
    private String fuelType;
    private Integer year;
    private Long manufacturerID;
    private Long supplierID;
    private String carStatus;
    private BigDecimal carRentingPricePerDay;
}

