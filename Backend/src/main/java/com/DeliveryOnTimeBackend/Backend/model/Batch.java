package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "locationId")
    private Location destination;

    @ManyToOne
    @JoinColumn(name = "current_location_id", referencedColumnName = "locationId")
    private Location currentLocation;  // Added current location

    @OneToMany(mappedBy = "batch")
    private List<Parcel> parcels;

    @Enumerated(EnumType.STRING)
    private BatchStatus status;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private Rider rider;

    private Integer maxParcels = 10; // default batch size limit

    public enum BatchStatus {
        PENDING, READY, IN_TRANSIT, DELIVERED
    }

    // Helper method to check if batch has capacity
    public boolean hasCapacity() {
        return parcels == null || parcels.size() < maxParcels;
    }
}