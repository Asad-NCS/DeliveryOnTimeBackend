package com.DeliveryOnTimeBackend.Backend.Responses;

import com.DeliveryOnTimeBackend.Backend.model.Location;
import com.DeliveryOnTimeBackend.Backend.model.Rider;
import lombok.Getter;
import lombok.Setter;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;

@Getter
@Setter
public class ChangeParcelPropertiesResponse {

    private Long parcelId;
    private ParcelStatus status;
    String Location;
    private Long riderId;
    private String deliveredDate;

}
