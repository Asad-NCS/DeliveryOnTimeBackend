package com.DeliveryOnTimeBackend.Backend.model;

import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "originId", referencedColumnName = "locationId")
    private Location originId;
    @ManyToOne
    @JoinColumn(name = "destinationId", referencedColumnName = "locationId")
    private Location destinationId;

    String address;
    String sendAddress;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Parcel(String type, float weight, Location origin, Location destination, Customer customer, Object o,String address,String sendAddress,Batch batch) {

        this.type = type;
        this.weight = weight;
        this.destinationId = destination;
        this.customerId = customer;
        this.address = address;
        this.originId = origin;
        this.sendAddress = sendAddress;
        this.batch = batch;
    }
}