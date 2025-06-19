package com.mss301.authservice.payload;

import lombok.Data;
import java.time.LocalDate;
import com.mss301.authservice.enums.Role;

@Data
public class CustomerPayload {
    private Long customerID;
    private String customerName;
    private String telephone;
    private String email;
    private LocalDate customerBirthday;
    private String customerStatus;
    private String password;
    private Role role;
}
