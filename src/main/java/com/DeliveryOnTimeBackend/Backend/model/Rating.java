package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Rating {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long RatingId;

  private int stars;
  private String Review;

  @ManyToOne
    private Rider rider;

}
