

package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Parcel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    String type;
    float weight;
    long order_id;
    long origin_id;
    long destination_id;


    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public long getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(long origin_id) {
        this.origin_id = origin_id;
    }

    public long getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(long destination_id) {
        this.destination_id = destination_id;
    }
}