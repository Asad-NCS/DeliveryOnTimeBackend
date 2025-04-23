

package com.DeliveryOnTimeBackend.Backend.model;

import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;
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

public class Parcel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parcelId;


    private String type;
    private float weight;
    private long orderId;
    private long originId;
    private long destinationId;

    @Enumerated(EnumType.STRING)
    ParcelStatus status;



}