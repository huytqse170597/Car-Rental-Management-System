package com.mss301.rentingservice.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class RentingTransactionDTO {
    private Long id;
    private Long customerId;
    private LocalDate transactionDate;
    private BigDecimal totalPrice;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<RentingDetailDTO> details;
}

