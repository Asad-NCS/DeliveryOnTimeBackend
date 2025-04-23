package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.model.Batch;
import com.DeliveryOnTimeBackend.Backend.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Batch")
public class BatchController {
    @Autowired
    private BatchRepository batchRepository;
    @GetMapping
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }
    @PostMapping
    public Batch addBatch(@RequestBody Batch batch) {
        return batchRepository.save(batch);
    }

}
