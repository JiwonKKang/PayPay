package com.example.banking.application.port.in;

public interface FindRegisteredBankAccountUseCase {

    RegisteredBankAccountResponse findBankAccount(FindRegisteredBankAccountCommand command);
}
