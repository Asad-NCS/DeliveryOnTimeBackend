package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck,Long> {
}
