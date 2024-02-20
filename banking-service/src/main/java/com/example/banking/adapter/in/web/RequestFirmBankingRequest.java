package com.example.banking.adapter.in.web;

import com.example.banking.application.port.in.RequestedFirmBankingCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmBankingRequest {
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private Integer moneyAmount;

    public RequestedFirmBankingCommand toCommand() {
        return RequestedFirmBankingCommand.builder()
                .fromBankName(fromBankName)
                .fromBankAccountNumber(fromBankAccountNumber)
                .toBankName(toBankName)
                .toBankAccountNumber(toBankAccountNumber)
                .moneyAmount(moneyAmount.longValue())
                .build();
    }

}
