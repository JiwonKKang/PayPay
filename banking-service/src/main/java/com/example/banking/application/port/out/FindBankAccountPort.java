package com.example.banking.application.port.out;

import com.example.banking.domain.RegisteredBankAccount;

public interface FindBankAccountPort {

    RegisteredBankAccount findBankAccount(Long registeredBankAccountId);

}
