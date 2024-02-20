package com.example.banking.application.port.out;

import com.example.banking.adapter.out.external.bank.BankAccount;
import com.example.banking.adapter.out.external.bank.GetBankAccountInfoRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountInfoRequest request);
}
