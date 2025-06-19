package com.mss301.rentingservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class RentingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private RentingTransaction transaction;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @Column(nullable = false)
    private Integer numberOfDays;
}

