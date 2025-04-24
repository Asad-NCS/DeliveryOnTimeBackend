package com.DeliveryOnTimeBackend.Backend.controller;

import com.DeliveryOnTimeBackend.Backend.Responses.RegisterVehicleResponse;
import com.DeliveryOnTimeBackend.Backend.extras.VehicleStatus;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rider")
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    @PostMapping
    public Rider createRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }


    @PostMapping("/registerVehicle")
    public ResponseEntity<?> addVehicle(@RequestBody RegisterVehicleResponse request){

        Optional<Rider> riderOptional = riderRepository.findById(request.getRiderId());

        Vehicle vehicle;
        VehicleStatus status;

        switch (request.getVehicleType().toLowerCase()) {
            case "truck":
                vehicle = new Truck( request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getTruckCapacity());
                break;
            case "ship":
                vehicle = new Ship(request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getCargoCapacity());
                break;
            case "airplane":
                vehicle = new Airplane(request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getMaxAltitude());
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid vehicle type");
        }

        vehicle = vehicleRepository.save(vehicle);

        Rider rider = riderOptional.get();
        rider.setVehicleId(vehicle);
        riderRepository.save(rider);

        return ResponseEntity.ok("Vehicle registered and assigned to rider");


    }


}
