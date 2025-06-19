package com.mss301.rentingservice.repositories;

import com.mss301.rentingservice.entities.RentingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentingDetailRepository extends JpaRepository<RentingDetail, Long> {
}

