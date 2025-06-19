package com.mss301.rentingservice.client;

import com.mss301.rentingservice.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service", url = "http://localhost:8082")
public interface CarServiceClient {

    @GetMapping("/api/cars/{id}")
    CarDTO getCarById(@PathVariable("id") Long id);
}

