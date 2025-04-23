


package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;

import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long parcel_id;
    @Enumerated(EnumType.STRING) // This tells JPA to save enum as a string (recommended)
    private ParcelStatus status;
    String placement_date;
    long customer_id;
    long payment_id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParcel_id() {
        return parcel_id;
    }

    public void setParcel_id(long order_id) {
        this.parcel_id = order_id;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    public String getPlacement_date() {
        return placement_date;
    }

    public void setPlacement_date(String placement_date) {
        this.placement_date = placement_date;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }
}



