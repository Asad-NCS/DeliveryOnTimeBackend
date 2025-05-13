package com.DeliveryOnTimeBackend.Backend.controller;

import com.DeliveryOnTimeBackend.Backend.extras.BatchStatus;
import com.DeliveryOnTimeBackend.Backend.model.Batch;
import com.DeliveryOnTimeBackend.Backend.model.Location;
import com.DeliveryOnTimeBackend.Backend.model.Rider;
import com.DeliveryOnTimeBackend.Backend.repository.BatchRepository;
import com.DeliveryOnTimeBackend.Backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Batch")
public class BatchController {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @GetMapping("/byLocation")
    public List<Batch> getBatchesByLocation(
            @RequestParam String city,
            @RequestParam String country) {

        Optional<Location> locationOpt = Optional.ofNullable(locationRepository.findByCityAndCountry(city, country));

        if (locationOpt.isPresent()) {
            return batchRepository.findByCurrentLocation(locationOpt.get());
        }
        return List.of();
    }

    @PostMapping
    public Batch createBatch(@RequestBody Batch batch) {
        if (batch.getStatus() == null) {
            batch.setStatus(BatchStatus.Pending);  // Changed from Batch.BatchStatus.PENDING
        }
        return batchRepository.save(batch);
    }

    @PostMapping("/assignRider")
    public Batch assignRiderToBatch(@RequestBody AssignRiderRequest req) {
        Batch batch = batchRepository.findById(req.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        Rider rider = new Rider();
        rider.setUserId(req.getRiderId());

        batch.setRider(rider);
        batch.setStatus(BatchStatus.Ready);  // Changed from Batch.BatchStatus.READY

        return batchRepository.save(batch);
    }

    static class AssignRiderRequest {
        private Long batchId;
        private Long riderId;

        public Long getBatchId() {
            return batchId;
        }

        public void setBatchId(Long batchId) {
            this.batchId = batchId;
        }

        public Long getRiderId() {
            return riderId;
        }

        public void setRiderId(Long riderId) {
            this.riderId = riderId;
        }
    }
}