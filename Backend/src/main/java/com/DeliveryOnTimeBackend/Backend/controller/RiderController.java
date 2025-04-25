package com.DeliveryOnTimeBackend.Backend.controller;

import com.DeliveryOnTimeBackend.Backend.Responses.RegisterVehicleResponse;
import com.DeliveryOnTimeBackend.Backend.extras.VehicleStatus;
import com.DeliveryOnTimeBackend.Backend.extras.VehicleType;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.TruckRepository;
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
    @Autowired
    private TruckRepository truckRepository;

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

        if(request.getVehicleType() == VehicleType.TRUCK)
            vehicle = new Truck( request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getTruckCapacity());
        else if(request.getVehicleType() == VehicleType.SHIP)
            vehicle = new Ship(request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getCargoCapacity());
        else if(request.getVehicleType() == VehicleType.AIRPLANE)
            vehicle = new Airplane(request.getModel(), request.getLicenseNumber(), request.getStatus(), request.getMaxAltitude());
        else vehicle = new Truck();
/*
        if(request.getVehicleType() == VehicleType.TRUCK){
            Truck truck = new Truck();
            truck.setModel(request.getModel());
            truck.setLicenseNumber(request.getLicenseNumber());
            truck.setStatus(request.getStatus());

            truckRepository.save(truck);
        }
/*
        if(user.getAccountType() == AccountType.Ship){
            Ship ship = new Ship();
            ship.setModel(user.getModel());
            ship.setLicenseNumber(user.getLicenseNumber());
            ship.setStatus(user.getVehicleStatus());

            shipRepository.save(ship);
        }

        if(user.getAccountType() == AccountType.Airplane){
            Airplane airplane = new Airplane();
            airplane.setModel(user.getModel());
            airplane.setLicenseNumber(user.getLicenseNumber());
            airplane.setStatus(user.getVehicleStatus());

            airplaneRepository.save(airplane);
        }

*/

        vehicle = vehicleRepository.save(vehicle);

        Rider rider = riderOptional.get();
        rider.setVehicleId(vehicle);
        riderRepository.save(rider);

        return ResponseEntity.ok("Vehicle registered and assigned to rider");


    }


}
