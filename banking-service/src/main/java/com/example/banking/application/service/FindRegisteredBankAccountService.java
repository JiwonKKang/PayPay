package com.example.banking.application.service;

import com.example.banking.application.port.in.FindRegisteredBankAccountCommand;
import com.example.banking.application.port.in.FindRegisteredBankAccountUseCase;
import com.example.banking.application.port.in.RegisteredBankAccountResponse;
import com.example.banking.application.port.out.FindBankAccountPort;
import com.example.banking.domain.RegisteredBankAccount;
import com.example.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindRegisteredBankAccountService implements FindRegisteredBankAccountUseCase {

    private final FindBankAccountPort findBankAccountPort;

    public RegisteredBankAccountResponse findBankAccount(FindRegisteredBankAccountCommand findRegisteredBankAccountCommand) {
        RegisteredBankAccount registeredBankAccount =
                findBankAccountPort.findBankAccount(findRegisteredBankAccountCommand.getRegisteredBankAccountId());

        return RegisteredBankAccountResponse.from(registeredBankAccount);
    }

}
