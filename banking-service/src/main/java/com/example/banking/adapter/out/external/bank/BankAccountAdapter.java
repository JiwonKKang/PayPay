package com.example.banking.adapter.out.external.bank;

import com.example.banking.application.port.out.RequestBankAccountInfoPort;
import com.example.common.ExternalAdapter;

@ExternalAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountInfoRequest request) {
        return BankAccount.from(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
