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
@NoArgsConstructor
@AllArgsConstructor

public class Airplane extends Vehicle {
    private double maxLoad;

    public Airplane(String model, String licenseNumber, VehicleStatus status, Double cargoCapacity) {
        super(model,licenseNumber,status);
        this.maxLoad = cargoCapacity;
    }
}
