package com.example.banking.application.port.in;

import com.example.banking.domain.RegisteredBankAccount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisteredBankAccountResponse {
    private final Long registeredBankAccountId;
    private final Long membershipId;
    private final String bankName;
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public static RegisteredBankAccountResponse from(RegisteredBankAccount registeredBankAccount) {
        return new RegisteredBankAccountResponse(
                registeredBankAccount.getRegisteredBankAccountId(),
                registeredBankAccount.getMembershipId(),
                registeredBankAccount.getBankName(),
                registeredBankAccount.getBankAccountNumber(),
                registeredBankAccount.isLinkedStatusIsValid()
        );
    }
}
