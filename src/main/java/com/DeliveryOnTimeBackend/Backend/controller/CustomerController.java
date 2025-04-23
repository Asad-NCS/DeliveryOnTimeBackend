package com.DeliveryOnTimeBackend.Backend.controller;


import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.model.Customer;
import com.DeliveryOnTimeBackend.Backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
