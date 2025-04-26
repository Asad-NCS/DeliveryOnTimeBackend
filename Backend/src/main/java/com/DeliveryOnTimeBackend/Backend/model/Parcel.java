

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
   // @OneToOne
    //@JoinColumn(name = "orderId", referencedColumnName = "orderId")
    //private Orders orderId;
    @ManyToOne
    @JoinColumn(name = "originId", referencedColumnName = "locationId")
    private Location originId;
    @ManyToOne
    @JoinColumn(name = "destinationId", referencedColumnName = "locationId")
    private Location destinationId;

   // @OneToMany(mappedBy = "parcelId", cascade = CascadeType.ALL)
    //private List<ParcelLog> logs;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    private Payment paymentId;
/*
    public Parcel(String type, float weight, Location destination, Orders order, Location origin) {
        this.type = type;
        this.weight = weight;
        this.destinationId = destination;
      //  this.orderId = order;
        this.originId = origin;

    }
*/
    public Parcel(String type, float weight, Location origin, Location destination, Customer customer, Object o) {

        this.type = type;
        this.weight = weight;
        this.destinationId = destination;
        this.customerId = customer;

        this.originId = origin;
    }
}