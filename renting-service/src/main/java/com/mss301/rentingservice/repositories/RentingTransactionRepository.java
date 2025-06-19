package com.mss301.rentingservice.repositories;

import com.mss301.rentingservice.entities.RentingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentingTransactionRepository extends JpaRepository<RentingTransaction, Long> {
    List<RentingTransaction> findByCustomerId(Long customerId);
    List<RentingTransaction> findAllByTransactionDateBetweenOrderByTransactionDateDesc(LocalDate startDate, LocalDate endDate);
}

