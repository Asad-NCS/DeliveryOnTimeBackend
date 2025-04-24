

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
    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Orders orderId;
    @ManyToOne
    @JoinColumn(name = "originId", referencedColumnName = "locationId")
    private Location originId;
    @ManyToOne
    @JoinColumn(name = "destinationId", referencedColumnName = "locationId")
    private Location destinationId;

    @OneToMany(mappedBy = "parcel", cascade = CascadeType.ALL)
    private List<ParcelLog> logs;



}