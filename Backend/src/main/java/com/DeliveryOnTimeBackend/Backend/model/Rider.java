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

public class Rider extends User {

    @OneToOne
    @JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId")
    private Vehicle vehicleId;


}
