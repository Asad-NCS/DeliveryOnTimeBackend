package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.model.Parcel;
import com.DeliveryOnTimeBackend.Backend.repository.ParcelLogRepository;
import com.DeliveryOnTimeBackend.Backend.repository.ParcelRepository;
import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.model.Payment;
import com.DeliveryOnTimeBackend.Backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    ParcelRepository parcelRepository;


    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }


    @GetMapping("/getpaymentfromparcel")
    public Payment getPaymentFromParcel(Long id){
        Parcel parcel = parcelRepository.findByparcelId(id);

        return paymentRepository.findByParcel(parcel);

    }


}

