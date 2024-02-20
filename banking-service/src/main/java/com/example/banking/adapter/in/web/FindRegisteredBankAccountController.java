package com.example.banking.adapter.in.web;

import com.example.banking.application.port.in.FindRegisteredBankAccountCommand;
import com.example.banking.application.port.in.FindRegisteredBankAccountUseCase;
import com.example.banking.application.port.in.RegisteredBankAccountResponse;
import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class FindRegisteredBankAccountController {

    private final FindRegisteredBankAccountUseCase findBankAccountUseCase;

    @GetMapping("/bank-accounts/{registeredBankAccountId}")
    public RegisteredBankAccountResponse findBankAccount(@PathVariable Long registeredBankAccountId) {
        return findBankAccountUseCase.findBankAccount(FindRegisteredBankAccountCommand.from(registeredBankAccountId));
    }

}
