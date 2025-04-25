

package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.Responses.SendParcelResponse;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;
import com.DeliveryOnTimeBackend.Backend.model.Customer;
import com.DeliveryOnTimeBackend.Backend.model.Location;
import com.DeliveryOnTimeBackend.Backend.model.Orders;
import com.DeliveryOnTimeBackend.Backend.repository.*;
import com.DeliveryOnTimeBackend.Backend.model.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcel")
public class ParcelController {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel){
        System.out.println("Saving parcel: " + parcel);
        return parcelRepository.save(parcel);

    }


    @PostMapping("/addParcel")
    public ResponseEntity<?> addParcel(@RequestBody SendParcelResponse response){

        Customer customerOptional= customerRepository.findByuserId(userRepository.findByuserId(response.getCustomerId()));

        // still need to add the paymentId
        Orders order = new Orders(ParcelStatus.WAITING,response.getPlacementDate(),customerOptional);

        Location destination = locationRepository.findByCityAndCountry(response.getDestinationCountry(),response.getDestinationCity());
        Location origin = locationRepository.findByCityAndCountry(response.getOriginCountry(), response.getOriginCity());


        Parcel parcel = new Parcel(response.getType(),response.getWeight(),destination,order,origin);

        ordersRepository.save(order);
        parcelRepository.save(parcel);


        return ResponseEntity.ok("Order and Parcel Have been Added");
    }

}
