package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.model.Rating;
import com.DeliveryOnTimeBackend.Backend.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Rating")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }
}
