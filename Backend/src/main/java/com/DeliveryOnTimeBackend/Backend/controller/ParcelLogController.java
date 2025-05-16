package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.Responses.ChangeParcelPropertiesResponse;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcelLog")
public class ParcelLogController {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    ParcelLogRepository parcelLogRepository;
    @Autowired
    RiderRepository riderRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    LocationRepository locationRepository;


    @GetMapping
    public ParcelLog getparcellog(@RequestParam Long parcelID){
        return parcelLogRepository.findByParcelId(parcelRepository.findByparcelId(parcelID));
    }

    @PostMapping("/changeStatus")
    ResponseEntity<?> changeStatus (@RequestBody ChangeParcelPropertiesResponse changeParcelStatusResponse) {

try {
    Parcel parcel = parcelRepository.findByparcelId(changeParcelStatusResponse.getParcelId());


    ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);


    parcelLog.setStatus(changeParcelStatusResponse.getStatus());

    parcelLogRepository.save(parcelLog);
    return ResponseEntity.ok("Status Changes Successfully");
} catch (Exception e) {
    throw new RuntimeException(e);
}
    }


    @PostMapping("/changeLocation")
    ResponseEntity<?> changeLocation (@RequestBody ChangeParcelPropertiesResponse changeParcelLocationResponse) {


try {
    Parcel parcel = parcelRepository.findByparcelId(changeParcelLocationResponse.getParcelId());


    ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);

    Batch batch = parcel.getBatch();
    Rider currentRider = batch.getRider();

    //Rider currentRider = parcelLog.getCurrentRider();

    Location newLocation = locationRepository.findFirstByCity(changeParcelLocationResponse.getLocation());
    System.out.println(newLocation);
    Location oldLocation = parcelLog.getLocation();
    // Location newLocation = changeParcelLocationResponse.getLocation();

    System.out.println(newLocation.getCity());
    System.out.println(oldLocation.getCity());

    float parcelWeight = parcel.getWeight();

    Route routeFollowed = routeRepository.findByDestinationAndOrigin(newLocation, oldLocation);

    float riderPayment = (float) (routeFollowed.getBasePayment() * parcelWeight * 0.03);

    currentRider.setDueAmount(currentRider.getDueAmount() + riderPayment);

    parcelLog.setLocation(newLocation);


    parcelLogRepository.save(parcelLog);
    return ResponseEntity.ok("Status Changes Successfully");

} catch (Exception e) {
    throw new RuntimeException(e);
}
    }

  /*  @PostMapping("/changeCurrentRider")
    ResponseEntity<?> changeCurrentRider (@RequestBody ChangeParcelPropertiesResponse changeCurrentRiderResponse) {


        Parcel parcel = parcelRepository.findByparcelId(changeCurrentRiderResponse.getParcelId());
        System.out.println(parcel.getParcelId());

        ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);
        System.out.println(parcelLog.getLogId());
        //System.out.println(parcelLog.getCurrentRider());
        Rider rider = riderRepository.findByUserId(changeCurrentRiderResponse.getRiderId());
        //parcelLog.setCurrentRider(rider);
        //System.out.println(parcelLog.getCurrentRider());
        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }
    */

    @PostMapping("/changeDeliveredDate")
    ResponseEntity<?> changeDeliveredDate (@RequestBody ChangeParcelPropertiesResponse changeDeliveredDateResponse) {



        Parcel parcel = parcelRepository.findByparcelId(changeDeliveredDateResponse.getParcelId());

        System.out.println(parcel.getParcelId());

        ParcelLog parcelLog = parcelLogRepository.findByParcelId(parcel);
        System.out.println(parcelLog.getLogId());

        System.out.println(parcelLog.getDeliveredDate());
        parcelLog.setDeliveredDate(changeDeliveredDateResponse.getDeliveredDate());
        System.out.println(parcelLog.getDeliveredDate());
        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }

}
