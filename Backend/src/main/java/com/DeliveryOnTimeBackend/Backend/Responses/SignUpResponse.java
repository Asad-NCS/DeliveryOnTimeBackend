package com.DeliveryOnTimeBackend.Backend.Responses;

import com.DeliveryOnTimeBackend.Backend.extras.AccountType;
import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


public class SignUpResponse {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private AccountType accountType;
    private String address;
    private String accountNo;


}