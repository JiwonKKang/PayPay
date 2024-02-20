package com.example.banking.application.service;

import com.example.banking.adapter.out.external.bank.BankAccount;
import com.example.banking.adapter.out.external.bank.GetBankAccountInfoRequest;
import com.example.banking.application.port.in.RegisterBankAccountCommand;
import com.example.banking.application.port.in.RegisterBankAccountUseCase;
import com.example.banking.application.port.in.RegisteredBankAccountResponse;
import com.example.banking.application.port.out.RegisterBankAccountPort;
import com.example.banking.application.port.out.RequestBankAccountInfoPort;
import com.example.banking.domain.RegisteredBankAccount;
import com.example.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccountResponse registerBankAccount(RegisterBankAccountCommand command) {

        if (isRegisterBankAccountNotAvailable(command)) {
            throw new RuntimeException("Bank account is not available");
        }

        RegisteredBankAccount registeredBankAccount = RegisteredBankAccount.generateRegisteredBankAccount(
                RegisteredBankAccount.RegisteredBankAccountId.notAssigned(),
                RegisteredBankAccount.MembershipId.from(command.getMembershipId()),
                RegisteredBankAccount.BankName.from(command.getBankName()),
                RegisteredBankAccount.BankAccountNumber.from(command.getBankAccountNumber()),
                RegisteredBankAccount.LinkedStatusIsValid.from(command.isLinkedStatusIsValid())
        );

        RegisteredBankAccount saved = registerBankAccountPort.registerBankAccount(registeredBankAccount);

        return RegisteredBankAccountResponse.from(saved);
    }

    private boolean isRegisterBankAccountNotAvailable(RegisterBankAccountCommand command) {
        BankAccount bankAccountInfo = requestBankAccountInfoPort
                .getBankAccountInfo(GetBankAccountInfoRequest.from(command.getBankName(), command.getBankAccountNumber()));
        
        boolean existsRegisteredBankAccount = registerBankAccountPort.existsRegisteredBankAccount(command.getMembershipId());

        return !bankAccountInfo.isValid() || existsRegisteredBankAccount;
    }
}
