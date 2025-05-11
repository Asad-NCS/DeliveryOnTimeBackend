package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private double amount;

    private String paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

     @ManyToOne
     @JoinColumn(name = "parcel_id")
     private Parcel parcel;

    public enum PaymentStatus {
        Paid, Pending, PartiallyPaid
    }
}
