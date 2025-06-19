package com.mss301.carservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierID;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String supplierName;

    @Column(length = 255)
    private String supplierDescription;

    @Column(nullable = false, length = 255)
    @NotBlank
    private String supplierAddress;
}
