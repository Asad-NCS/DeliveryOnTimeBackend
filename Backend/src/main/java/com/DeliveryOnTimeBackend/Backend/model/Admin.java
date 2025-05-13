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

@PrimaryKeyJoinColumn(name = "adminId")
public class Admin extends User {

    /*  @OneToOne
      @JoinColumn(name ="riderId",referencedColumnName = "userId")
      User riderId;
  */
    private String authority;
    //   public Rider(User user) {
    //     this.riderId = user;
    //}
}
