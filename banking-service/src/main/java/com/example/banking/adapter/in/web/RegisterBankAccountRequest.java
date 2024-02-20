package com.example.banking.adapter.in.web;

import com.example.banking.application.port.in.RegisterBankAccountCommand;

public record RegisterBankAccountRequest(
        Long membershipId,
        String bankName,
        String bankAccountNumber,
        boolean linkedStatusIsValid
) {

    public RegisterBankAccountCommand toCommand() {
        return RegisterBankAccountCommand.builder()
                .membershipId(membershipId)
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .linkedStatusIsValid(linkedStatusIsValid)
                .build();
    }

}
