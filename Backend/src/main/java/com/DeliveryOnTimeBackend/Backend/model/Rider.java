package com.DeliveryOnTimeBackend.Backend.model;

import jakarta.annotation.Nullable;
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

@PrimaryKeyJoinColumn(name = "riderId")
public class Rider extends User {

  /*  @OneToOne
    @JoinColumn(name ="riderId",referencedColumnName = "userId")
    User riderId;
*/
    @OneToOne
    @JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId")
    private Vehicle vehicleId;

    @Column(nullable = true)
    private int accoundNo;
    private float dueAmount = 0;

 //   public Rider(User user) {
   //     this.riderId = user;
    //}
}
