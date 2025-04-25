package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends User {

/*    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    private User customerId;
*/


    private String address;
/*
    public Customer(User user) {
        this.customerId = user;
    }
*/
}

