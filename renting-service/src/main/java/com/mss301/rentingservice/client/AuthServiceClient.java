package com.mss301.rentingservice.client;

import com.mss301.rentingservice.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service", url = "http://localhost:8081")
public interface AuthServiceClient {

    @GetMapping("/api/customers/by-email/{email}")
    CustomerDTO getCustomerByEmail(@PathVariable("email") String email);
}

