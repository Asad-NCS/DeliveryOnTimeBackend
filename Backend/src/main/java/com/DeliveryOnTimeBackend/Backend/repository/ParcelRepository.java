package com.DeliveryOnTimeBackend.Backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DeliveryOnTimeBackend.Backend.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel,Long> {

}
