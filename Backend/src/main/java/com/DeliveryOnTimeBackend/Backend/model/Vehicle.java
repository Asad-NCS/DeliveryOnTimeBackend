package com.DeliveryOnTimeBackend.Backend.model;


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
    private String status;

}
