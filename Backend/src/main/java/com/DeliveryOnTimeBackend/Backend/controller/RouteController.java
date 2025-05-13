package com.DeliveryOnTimeBackend.Backend.controller;


import com.DeliveryOnTimeBackend.Backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;




}
