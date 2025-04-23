package com.DeliveryOnTimeBackend.Backend.model;

import com.DeliveryOnTimeBackend.Backend.extras.AccountType;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phone;
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
