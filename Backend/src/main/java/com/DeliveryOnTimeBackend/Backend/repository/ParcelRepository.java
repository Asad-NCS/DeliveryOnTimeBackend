package com.DeliveryOnTimeBackend.Backend.repository;


import com.DeliveryOnTimeBackend.Backend.model.Batch;
import com.DeliveryOnTimeBackend.Backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DeliveryOnTimeBackend.Backend.model.Parcel;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel,Long> {


   Parcel findByparcelId(Long id);
   List<Parcel> findByBatch(Batch batch);
   List<Parcel> findByCustomerId(Customer customer);
}
