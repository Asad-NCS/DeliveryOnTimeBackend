

package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.Responses.SendParcelResponse;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;
import com.DeliveryOnTimeBackend.Backend.extras.PaymentStatus;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parcel")
public class ParcelController {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LocationRepository locationRepository;
    //@Autowired
    //OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParcelLogRepository parcelLogRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    PaymentRepository paymentRepository;


    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel){
        System.out.println("Saving parcel: " + parcel);
        return parcelRepository.save(parcel);

    }



    @PostMapping("/addParcel")
    public ResponseEntity<?> addParcel(@RequestBody SendParcelResponse response){

      //  Customer customerOptional= customerRepository.findByuserId(userRepository.findByuserId(response.getCustomerId()));

      //  User user = userRepository.findByuserId(response.getCustomerId());
        Customer customer = customerRepository.findByuserId(response.getCustomerId());


     //   Customer customerOptional= customerRepository.findByuserId(userRepository.findByuserId(response.getCustomerId()));
      //  Customer customerOptional= customerRepository.findByuserId(response.getCustomerId());


        // still need to add the paymentId
       // Orders order = new Orders(response.getStatus(),response.getPlacementDate(),customer);



        Location destination = locationRepository.findFirstByCityAndCountry(response.getDestinationCity(),response.getDestinationCountry());
        Location origin = locationRepository.findFirstByCityAndCountry(response.getOriginCity(),response.getOriginCountry());
        System.out.println(response.getDestinationCountry() + " " + response.getDestinationCity());
        System.out.println(response.getOriginCountry() +" "+ response.getOriginCity());

        System.out.println(destination);
        System.out.println(origin);

        Parcel parcel = new Parcel(response.getType(),response.getWeight(),origin,destination,customer,null,response.getAddress());

        ParcelLog parcelLog = new ParcelLog(null,parcel,ParcelStatus.WAITING,response.getPlacementDate(),origin,null,null);
      //  ordersRepository.save(order);
        parcelRepository.save(parcel);

        parcelLogRepository.save(parcelLog);

                Route route = Optional.ofNullable(routeRepository.findByDestinationAndOrigin(destination, origin))
                .orElseThrow(() -> new RuntimeException("No route found from origin to destination"));


      //  Route route = routeRepository.findByDestinationAndOrigin(destination,origin);
        System.out.println(route);

        float amount = route.getBasePayment() * parcel.getWeight();

        Payment payment = new Payment(null, amount,null, PaymentStatus.Pending,parcel);

        paymentRepository.save(payment);

     //   float amount = parcel.getWeight() * route.getBasePayment();


        return ResponseEntity.ok("Parcel, Parcel_log, Payment Have been Added");
    }

}
/*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "parcelId",referencedColumnName = "parcelId")
    private Parcel parcelId;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "updatedByUserId")
    private User updatedBy;*/