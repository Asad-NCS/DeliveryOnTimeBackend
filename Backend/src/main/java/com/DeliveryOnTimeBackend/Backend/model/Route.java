package com.DeliveryOnTimeBackend.Backend.model;


import jakarta.persistence.*;

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
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long routeId;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Location originId;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Location destinationId;

    private float basePayment;

}
