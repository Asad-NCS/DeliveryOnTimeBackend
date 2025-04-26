package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {


    Rider findByUserId(Long userId);

}
