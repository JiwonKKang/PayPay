package com.example.banking.application.port.in;

import com.example.banking.domain.RequestedFirmBanking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RequestedFirmBankingResponse {

    private final Long requestedFirmBankingId;
    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final Long moneyAmount;
    private final int firmBankingStatus; // 0: 요청 중, 1: 요청 완료, 2: 요청 실패
    private final UUID uuid;

    public static RequestedFirmBankingResponse from(RequestedFirmBanking domain) {
        return new RequestedFirmBankingResponse(
                domain.getRequestedFirmBankingId(),
                domain.getFromBankName(),
                domain.getFromBankAccountNumber(),
                domain.getToBankName(),
                domain.getToBankAccountNumber(),
                domain.getMoneyAmount(),
                domain.getFirmBankingStatus(),
                domain.getUuid()
        );
    }

}
