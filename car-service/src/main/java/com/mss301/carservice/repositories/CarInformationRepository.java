package com.mss301.carservice.repositories;

import com.mss301.carservice.entities.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Long> {
}

