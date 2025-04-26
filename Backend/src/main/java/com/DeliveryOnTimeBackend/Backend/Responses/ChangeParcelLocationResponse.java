package com.DeliveryOnTimeBackend.Backend.Responses;



import com.DeliveryOnTimeBackend.Backend.model.Location;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChangeParcelLocationResponse {

    Long parcelId;
    Location location;

}
