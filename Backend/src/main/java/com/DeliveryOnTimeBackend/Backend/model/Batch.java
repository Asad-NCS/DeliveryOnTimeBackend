package com.DeliveryOnTimeBackend.Backend.model;

import com.DeliveryOnTimeBackend.Backend.extras.BatchStatus;
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
    private Location currentLocation;

    @OneToMany(mappedBy = "batch")
    private List<Parcel> parcels;

    @Enumerated(EnumType.STRING)
    private BatchStatus status;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private Rider rider;

    private Integer maxParcels = 10;
}