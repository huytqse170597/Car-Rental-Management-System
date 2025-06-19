package com.mss301.authservice.entities;

import com.mss301.authservice.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @Column(nullable = false, length = 100)
    private String customerName;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(nullable = false, unique = true, length = 100)
    @jakarta.validation.constraints.Email
    private String email;

    private LocalDate customerBirthday;

    @Column(nullable = false, length = 20)
    private String customerStatus;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;
}
