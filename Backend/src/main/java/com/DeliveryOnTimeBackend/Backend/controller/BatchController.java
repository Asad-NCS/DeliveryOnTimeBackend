package com.DeliveryOnTimeBackend.Backend.controller;

import com.DeliveryOnTimeBackend.Backend.Responses.ChangeBatchProperties;
import com.DeliveryOnTimeBackend.Backend.Responses.ChangeParcelPropertiesResponse;
import com.DeliveryOnTimeBackend.Backend.extras.BatchStatus;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.BatchRepository;
import com.DeliveryOnTimeBackend.Backend.repository.LocationRepository;
import com.DeliveryOnTimeBackend.Backend.repository.RiderRepository;
import com.DeliveryOnTimeBackend.Backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private RouteRepository routeRepository;

    // rider should also be able to change the status of a batch to delievered

    // when the rider drops a batch in a city
    @PostMapping("/dropBatch")
    ResponseEntity<?> dropBatch (@RequestParam long batchId) {
        Batch batch = batchRepository.findByBatchId(batchId);
        batch.setRider(null);
        batch.setStatus(BatchStatus.Ready);
        System.out.println("Batch"+batchId+"dropped");
        batchRepository.save(batch);
        return ResponseEntity.ok("Dropped");
    }


    // to change the current rider attribute whenervt a rider picks up a batch
        @PostMapping("/changeCurrentRider")
    ResponseEntity<?> changeCurrentRider (@RequestBody ChangeBatchProperties changeBatchProperties) {


    //    Parcel parcel = parcelRepository.findByparcelId(changeCurrentRiderResponse.getParcelId());
    //    System.out.println(parcel.getParcelId());

        Batch batch = batchRepository.findByBatchId( changeBatchProperties.getBatchId());
        Rider rider = riderRepository.findByUserId(changeBatchProperties.getRiderId());
        batch.setRider(rider);


        // ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);
       // System.out.println(parcelLog.getLogId());
        //System.out.println(parcelLog.getCurrentRider());
        //Rider rider = riderRepository.findByUserId(changeCurrentRiderResponse.getRiderId());
        //parcelLog.setCurrentRider(rider);
        //System.out.println(parcelLog.getCurrentRider());
        //parcelLogRepository.save(parcelLog);
        batchRepository.save(batch);

        return ResponseEntity.ok("Status Changes Successfully");

    }


    // when a rider changes the location of a batch,
    // this will generate the due amount od the rider as well
    @PostMapping("/changeLocation")
    ResponseEntity<?> changeLocation (@RequestBody ChangeBatchProperties changeBatchLocation) {


        try {
         //   Parcel parcel = parcelRepository.findByparcelId(changeParcelLocationResponse.getParcelId());


//            ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);

            Batch batch = batchRepository.findByBatchId(changeBatchLocation.getBatchId());
            //Batch batch = parcel.getBatch();
            Rider currentRider = batch.getRider();

            //Rider currentRider = parcelLog.getCurrentRider();

            Location newLocation = locationRepository.findFirstByCity(changeBatchLocation.getLocation());
            System.out.println(newLocation);
            Location oldLocation = batch.getCurrentLocation();
            // Location newLocation = changeParcelLocationResponse.getLocation();

            System.out.println(newLocation.getCity());
            System.out.println(oldLocation.getCity());

            //float parcelWeight = parcel.getWeight();
            float batchWeight = batch.getWeight();

            Route routeFollowed = routeRepository.findByDestinationAndOrigin(newLocation, oldLocation);

            float riderPayment = (float) (routeFollowed.getBasePayment() * batchWeight * 0.03);

            currentRider.setDueAmount(currentRider.getDueAmount() + riderPayment);

            batch.setCurrentLocation(newLocation);


           // parcelLogRepository.save(parcelLog);
            batchRepository.save(batch);
            riderRepository.save(currentRider);


            return ResponseEntity.ok("Status Changes Successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





    @GetMapping
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @GetMapping("/byLocation")
    public List<Batch> getBatchesByLocation(
            @RequestParam String city,
            @RequestParam String country) {

        Optional<Optional<Location>> locationOpt = Optional.ofNullable(locationRepository.findByCityAndCountry(city, country));

        if (locationOpt.isPresent()) {
            return batchRepository.findByCurrentLocationAndStatus(locationOpt.get() , BatchStatus.Ready);
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
        batch.setStatus(BatchStatus.IN_TRANSIT);  // Changed from Batch.BatchStatus.READY

        return batchRepository.save(batch);
    }

    @GetMapping("/getriderbatches")
    public List<Batch> getBatchesOfRider(@RequestParam long riderId){

        Rider rider = riderRepository.findByUserId(riderId);

        return batchRepository.findByRider(rider);

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