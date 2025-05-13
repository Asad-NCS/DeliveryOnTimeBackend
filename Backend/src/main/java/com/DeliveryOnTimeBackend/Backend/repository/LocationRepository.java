package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCityAndCountry(String city, String country);
}