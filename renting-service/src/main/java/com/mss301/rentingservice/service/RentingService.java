package com.mss301.rentingservice.service;

import com.mss301.rentingservice.client.AuthServiceClient;
import com.mss301.rentingservice.client.CarServiceClient;
import com.mss301.rentingservice.dto.CarDTO;
import com.mss301.rentingservice.dto.RentingRequest;
import com.mss301.rentingservice.dto.RentingTransactionDTO;
import com.mss301.rentingservice.entities.RentingDetail;
import com.mss301.rentingservice.entities.RentingTransaction;
import com.mss301.rentingservice.mapper.RentingTransactionMapper;
import com.mss301.rentingservice.repositories.RentingTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentingService {

    private final RentingTransactionRepository transactionRepository;
    private final RentingTransactionMapper transactionMapper;
    private final CarServiceClient carServiceClient;
    private final AuthServiceClient authServiceClient;

    public RentingTransactionDTO createRenting(RentingRequest request) {
        CarDTO car = carServiceClient.getCarById(request.getCarId());

        RentingTransaction transaction = new RentingTransaction();
        transaction.setCustomerId(request.getCustomerId());
        transaction.setTransactionDate(LocalDate.now());
        transaction.setStartDate(request.getStartDate());
        transaction.setEndDate(request.getEndDate());
        transaction.setStatus("Rented");

        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        BigDecimal pricePerDay = car.getPricePerDay();
        transaction.setTotalPrice(pricePerDay.multiply(BigDecimal.valueOf(days)));

        RentingDetail detail = new RentingDetail();
        detail.setTransaction(transaction);
        detail.setCarId(request.getCarId());
        detail.setNumberOfDays((int) days);
        detail.setPricePerDay(pricePerDay);

        transaction.setDetails(Collections.singletonList(detail));

        RentingTransaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toDto(savedTransaction);
    }

    public List<RentingTransactionDTO> getHistoryForCustomer(Long customerId) {
        return transactionRepository.findByCustomerId(customerId).stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RentingTransactionDTO> getReport(LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findAllByTransactionDateBetweenOrderByTransactionDateDesc(startDate, endDate).stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }
}
