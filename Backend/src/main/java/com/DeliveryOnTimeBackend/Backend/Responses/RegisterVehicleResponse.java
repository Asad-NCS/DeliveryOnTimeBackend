package com.DeliveryOnTimeBackend.Backend.Responses;

import com.DeliveryOnTimeBackend.Backend.extras.VehicleStatus;

import com.DeliveryOnTimeBackend.Backend.extras.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterVehicleResponse {

    private Long riderId;

    private VehicleType vehicleType; // "Truck", "Ship", "Airplane"
    private String model;
    private String licenseNumber;

    private VehicleStatus status;

    // Optional fields depending on vehicle type
    private Double truckCapacity;
    private Double cargoCapacity;
    private Double maxAltitude;



}
