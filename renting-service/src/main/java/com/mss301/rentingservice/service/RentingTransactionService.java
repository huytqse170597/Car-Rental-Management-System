package com.mss301.rentingservice.service;

import com.mss301.rentingservice.dto.RentingTransactionDTO;
import java.util.List;

public interface RentingTransactionService {
    RentingTransactionDTO create(RentingTransactionDTO dto);
    RentingTransactionDTO update(Long id, RentingTransactionDTO dto);
    void delete(Long id);
    RentingTransactionDTO getById(Long id);
    List<RentingTransactionDTO> getAll();
}

