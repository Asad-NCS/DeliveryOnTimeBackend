package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Parcel;
import com.DeliveryOnTimeBackend.Backend.model.ParcelLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParcelLogRepository extends JpaRepository<ParcelLog, Long> {

     ParcelLog findByparcelId(Parcel parcel);

}
