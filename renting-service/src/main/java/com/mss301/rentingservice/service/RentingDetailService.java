package com.mss301.rentingservice.service;

import com.mss301.rentingservice.dto.RentingDetailDTO;
import java.util.List;

public interface RentingDetailService {
    RentingDetailDTO create(RentingDetailDTO dto);
    RentingDetailDTO update(Long id, RentingDetailDTO dto);
    void delete(Long id);
    RentingDetailDTO getById(Long id);
    List<RentingDetailDTO> getAll();
}

