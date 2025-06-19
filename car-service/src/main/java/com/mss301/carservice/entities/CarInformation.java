package com.mss301.carservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class CarInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carID;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String carName;

    @Column(length = 255)
    private String carDescription;

    @Column(nullable = false)
    @Min(2)
    @Max(10)
    private Integer numberOfDoors;

    @Column(nullable = false)
    @Min(1)
    @Max(100)
    private Integer seatingCapacity;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String fuelType;

    @Column(nullable = false)
    @Min(1886)
    @Max(2100)
    private Integer year;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manufacturerID")
    private Manufacturer manufacturer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplierID")
    private Supplier supplier;

    @Column(nullable = false, length = 20)
    @NotBlank
    private String carStatus;

    @Column(nullable = false, precision = 15, scale = 2)
    @DecimalMin("0.0")
    private BigDecimal carRentingPricePerDay;
}
