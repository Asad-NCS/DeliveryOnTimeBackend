package com.DeliveryOnTimeBackend.Backend.repository;

import com.DeliveryOnTimeBackend.Backend.model.Parcel;
import com.DeliveryOnTimeBackend.Backend.model.ParcelLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelLogRepository extends JpaRepository<ParcelLog, Long> {

     ParcelLog findByParcelId(Parcel parcel);

}
