package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.extras.BatchStatus;
import com.DeliveryOnTimeBackend.Backend.model.Batch;
import com.DeliveryOnTimeBackend.Backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByCurrentLocation(Optional<Location> location);

  //  Batch findByOriginAndDestinationAndWeightLessThan(Location origin, Location destination, float weight);

    Batch findByCurrentLocationAndDestinationAndStatusAndWeightLessThan(Location origin, Location currentLocation, BatchStatus status, float weight);

    //Optional<Batch> findByOriginAndCurrentLocationAndWeightLessThan(Location origin, Location currentLocation, float weight);

    Batch findByBatchId(long batchId);

}