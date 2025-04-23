package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.model.Rider;
import com.DeliveryOnTimeBackend.Backend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rider")
public class RiderController {

    @Autowired
    private RiderRepository riderRepository;

    @GetMapping
    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    @PostMapping
    public Rider createRider(@RequestBody Rider rider) {
        return riderRepository.save(rider);
    }
}
