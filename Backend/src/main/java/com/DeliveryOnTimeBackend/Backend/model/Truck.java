package com.DeliveryOnTimeBackend.Backend.model;

import com.DeliveryOnTimeBackend.Backend.extras.VehicleStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Truck extends Vehicle {


    private double truckCapacity;

    public Truck(String model, String licenseNumber, VehicleStatus status, Double cargoCapacity) {
        super(model,licenseNumber,status);
        this.truckCapacity = cargoCapacity;
    }
}
