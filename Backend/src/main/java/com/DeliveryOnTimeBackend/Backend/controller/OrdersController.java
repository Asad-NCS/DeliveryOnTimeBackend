package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.model.Orders;
//import com.DeliveryOnTimeBackend.Backend.repository.OrdersRepository;
import com.DeliveryOnTimeBackend.Backend.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Map;


//@RestController
//@RequestMapping("/api/orders")
public class OrdersController {


 //   @Autowired
 //   OrdersRepository ordersRepository;

   // @PostMapping("addOrder")
    //public Orders addorder(@RequestBody Orders order) {
      //  System.out.println("Saving parcel: " + order);
        //return ordersRepository.save(order);

    //}

  /*  @PostMapping("sendParcelId")
    public ResponseEntity<String> setParcelId(@RequestBody Map<String, Long> payload) {
        Long parcelId = payload.get("parcel_id");

        // Do something with parcelId here, like setting it on an existing Order
        System.out.println("Received parcel_id: " + parcelId);

        return ResponseEntity.ok("parcel_id set to: " + parcelId);
    }*/



}
