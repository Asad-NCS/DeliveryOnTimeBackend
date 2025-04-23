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

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PaymentId;

    private String method;
    private double amount;
    private String PaymentDate;



}
