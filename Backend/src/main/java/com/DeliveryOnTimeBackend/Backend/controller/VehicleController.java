package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.model.User;
import com.DeliveryOnTimeBackend.Backend.model.Vehicle;
import com.DeliveryOnTimeBackend.Backend.repository.VehicleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    VehicleRepository vehicleRepository;

    @PostMapping("/addVehicle")
    public Vehicle addvehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.save(vehicle);

    }
}
