package com.example.banking.adapter.out.external.bank;

import lombok.Data;

@Data(staticConstructor = "from")
public class GetBankAccountInfoRequest {

    private final String bankName;
    private final String bankAccountNumber;

}
