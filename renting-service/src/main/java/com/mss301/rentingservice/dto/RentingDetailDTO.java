package com.mss301.rentingservice.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RentingDetailDTO {
    private Long id;
    private Long carId;
    private BigDecimal pricePerDay;
    private Integer numberOfDays;
}
