package com.DeliveryOnTimeBackend.Backend.model;


import com.DeliveryOnTimeBackend.Backend.extras.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long vehicleId;

    private String model;
    private String licenseNumber;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    public Vehicle(String model, String licenseNumber, VehicleStatus status) {
        this.model = model;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }
}
