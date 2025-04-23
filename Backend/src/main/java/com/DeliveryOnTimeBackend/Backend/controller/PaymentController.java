package com.DeliveryOnTimeBackend.Backend.controller;


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

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }
}

