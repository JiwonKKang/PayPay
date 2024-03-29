package com.example.banking.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Membership {

    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isValid;
    private boolean isCorp;
}
