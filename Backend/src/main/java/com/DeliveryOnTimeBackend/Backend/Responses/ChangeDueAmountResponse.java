package com.DeliveryOnTimeBackend.Backend.Responses;



import com.DeliveryOnTimeBackend.Backend.model.Location;
import com.DeliveryOnTimeBackend.Backend.model.Rider;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChangeDueAmountResponse {

    Long riderId;
    float amount;

}

