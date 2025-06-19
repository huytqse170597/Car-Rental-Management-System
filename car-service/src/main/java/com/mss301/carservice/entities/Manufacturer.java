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
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerID;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String manufacturerName;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String manufacturerCountry;
}
