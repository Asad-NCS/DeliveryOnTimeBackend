package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer extends User {

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    private User customerId;

    private String address;

}

