package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.Responses.ChangeParcelPropertiesResponse;
import com.DeliveryOnTimeBackend.Backend.model.Parcel;
import com.DeliveryOnTimeBackend.Backend.model.ParcelLog;
import com.DeliveryOnTimeBackend.Backend.model.Rider;
import com.DeliveryOnTimeBackend.Backend.model.User;
import com.DeliveryOnTimeBackend.Backend.repository.ParcelLogRepository;
import com.DeliveryOnTimeBackend.Backend.repository.ParcelRepository;
import com.DeliveryOnTimeBackend.Backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcelLog")
public class ParcelLogController {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    ParcelLogRepository parcelLogRepository;
    @Autowired
    RiderRepository riderRepository;

    @GetMapping
    public ParcelLog getparcellog(@RequestParam Long parcelID){return parcelLogRepository.findByparcelId(parcelRepository.findByparcelId(parcelID));}

    @PostMapping("/changeStatus")
    ResponseEntity<?> changeStatus (@RequestBody ChangeParcelPropertiesResponse changeParcelStatusResponse) {


        Parcel parcel = parcelRepository.findByparcelId(changeParcelStatusResponse.getParcelId());


        ParcelLog parcelLog = parcelLogRepository.findByparcelId(parcel);


        parcelLog.setStatus(changeParcelStatusResponse.getStatus());

        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }


    @PostMapping("/changeLocation")
    ResponseEntity<?> changeLocation (@RequestBody ChangeParcelPropertiesResponse changeParcelLocationResponse) {


        Parcel parcel = parcelRepository.findByparcelId(changeParcelLocationResponse.getParcelId());


        ParcelLog parcelLog = parcelLogRepository.findByparcelId(parcel);


        parcelLog.setLocation(changeParcelLocationResponse.getLocation());


        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }

    @PostMapping("/changeCurrentRider")
    ResponseEntity<?> changeCurrentRider (@RequestBody ChangeParcelPropertiesResponse changeCurrentRiderResponse) {


        Parcel parcel = parcelRepository.findByparcelId(changeCurrentRiderResponse.getParcelId());
        System.out.println(parcel.getParcelId());

        ParcelLog parcelLog = parcelLogRepository.findByparcelId(parcel);
        System.out.println(parcelLog.getLogId());
        System.out.println(parcelLog.getCurrentRider());
        Rider rider = riderRepository.findByUserId(changeCurrentRiderResponse.getRiderId());
        parcelLog.setCurrentRider(rider);
        System.out.println(parcelLog.getCurrentRider());
        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }
    @PostMapping("/changeDeliveredDate")
    ResponseEntity<?> changeDeliveredDate (@RequestBody ChangeParcelPropertiesResponse changeDeliveredDateResponse) {



        Parcel parcel = parcelRepository.findByparcelId(changeDeliveredDateResponse.getParcelId());

        System.out.println(parcel.getParcelId());

        ParcelLog parcelLog = parcelLogRepository.findByparcelId(parcel);
        System.out.println(parcelLog.getLogId());

        System.out.println(parcelLog.getDeliveredDate());
        parcelLog.setDeliveredDate(changeDeliveredDateResponse.getDeliveredDate());
        System.out.println(parcelLog.getDeliveredDate());
        parcelLogRepository.save(parcelLog);
        return ResponseEntity.ok("Status Changes Successfully");

    }

}
