


package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long orderid;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;
    String placementDate;
    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerId")
    private Customer customerId;
    @ManyToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    private Payment paymentId;

    }




