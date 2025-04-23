package com.DeliveryOnTimeBackend.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DeliveryOnTimeBackend.Backend.model.Batch;


@Repository
public interface BatchRepository extends JpaRepository <Batch,Integer>{

}
