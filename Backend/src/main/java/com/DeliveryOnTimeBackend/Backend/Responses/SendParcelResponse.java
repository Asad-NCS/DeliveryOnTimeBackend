package com.DeliveryOnTimeBackend.Backend.Responses;

import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendParcelResponse {

    private long customerId;
    private String destinationCity;
    private String destinationCountry;
    private String originCity;
    private String originCountry;
    private String placementDate;
    private ParcelStatus status;
    private long paymentId;
    private String type;
    private float weight;
    private String address;
    private String sendAddress;

}
