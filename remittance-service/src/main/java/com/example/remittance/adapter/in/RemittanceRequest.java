package com.example.remittance.adapter.in;

import com.example.remittance.domain.RemittanceRequestType;

public record RemittanceRequest(
        Long fromMembershipId,
        Long toMembershipId,
        String toBankName,
        String toBankAccountNumber,
        RemittanceRequestType remittanceRequestType,
        int moneyAmount
) {

}
