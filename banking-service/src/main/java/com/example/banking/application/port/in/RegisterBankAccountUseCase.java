package com.example.banking.application.port.in;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccountResponse registerBankAccount(RegisterBankAccountCommand command);

}
