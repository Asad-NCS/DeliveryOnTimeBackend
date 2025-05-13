package com.DeliveryOnTimeBackend.Backend.repository;


import com.DeliveryOnTimeBackend.Backend.model.Location;
import com.DeliveryOnTimeBackend.Backend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {


         Route findByDestinationIdAndOriginId(Location destinationId, Location originId);


}
