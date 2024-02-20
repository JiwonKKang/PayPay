package com.example.banking.adapter.in.web;

import com.example.banking.application.port.in.RegisterBankAccountUseCase;
import com.example.banking.application.port.in.RegisteredBankAccountResponse;
import com.example.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/bank-accounts")
    public RegisteredBankAccountResponse registerBankAccount(@RequestBody RegisterBankAccountRequest request) {
        return registerBankAccountUseCase.registerBankAccount(request.toCommand());
    }

}
