

package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.Responses.SendParcelResponse;
import com.DeliveryOnTimeBackend.Backend.extras.ParcelStatus;
import com.DeliveryOnTimeBackend.Backend.model.*;
import com.DeliveryOnTimeBackend.Backend.repository.*;
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
    @Autowired
    ParcelLogRepository parcelLogRepository;



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
        Customer customerOptional= customerRepository.findByuserId(response.getCustomerId());


        // still need to add the paymentId
        Orders order = new Orders(response.getStatus(),response.getPlacementDate(),customerOptional);

        Location destination = locationRepository.findByCityAndCountry(response.getDestinationCountry(),response.getDestinationCity());
        Location origin = locationRepository.findByCityAndCountry(response.getOriginCountry(), response.getOriginCity());


        Parcel parcel = new Parcel(response.getType(),response.getWeight(),destination,order,origin);

        ParcelLog parcelLog = new ParcelLog(null,parcel,ParcelStatus.WAITING,response.getPlacementDate(),origin,null,null);
        ordersRepository.save(order);
        parcelRepository.save(parcel);

        parcelLogRepository.save(parcelLog);


        return ResponseEntity.ok("Order and Parcel Have been Added");
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