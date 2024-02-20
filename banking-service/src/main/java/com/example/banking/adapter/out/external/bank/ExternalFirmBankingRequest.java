package com.example.banking.adapter.out.external.bank;

import lombok.Builder;
import lombok.Data;

@Data
public class ExternalFirmBankingRequest {

    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final Long moneyAmount;

    @Builder
    public ExternalFirmBankingRequest(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, Long moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
    }
}
