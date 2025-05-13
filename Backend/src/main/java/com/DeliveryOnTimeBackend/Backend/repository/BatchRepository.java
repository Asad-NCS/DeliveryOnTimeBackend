package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Batch;
import com.DeliveryOnTimeBackend.Backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByCurrentLocation(Location location);
}