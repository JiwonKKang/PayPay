package com.example.banking.application.port.out;

import com.example.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccount registerBankAccount(RegisteredBankAccount registeredBankAccount);

    boolean existsRegisteredBankAccount(Long membershipId);

}
