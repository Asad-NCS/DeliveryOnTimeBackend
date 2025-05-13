package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


    Location findFirstByCityAndCountry(String city, String country);
    Location findFirstByCity(String city);

    Optional<Location> findByCityAndCountry(String city, String country);
}
