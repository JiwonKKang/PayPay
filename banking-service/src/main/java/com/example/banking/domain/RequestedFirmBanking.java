package com.example.banking.domain;

import com.example.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class RequestedFirmBanking {

    private final Long requestedFirmBankingId;
    private final String fromBankName;
    private final String fromBankAccountNumber;
    private final String toBankName;
    private final String toBankAccountNumber;
    private final Long moneyAmount;
    private int firmBankingStatus; // 0: 요청 중, 1: 요청 완료, 2: 요청 실패
    private final UUID uuid;

    public static RequestedFirmBanking generateRequestedFirmBanking(
            RequestedFirmBankingId requestedFirmBankingId,
            FromBankName fromBankName,
            FromBankAccountNumber fromBankAccountNumber,
            ToBankName toBankName,
            ToBankAccountNumber toBankAccountNumber,
            MoneyAmount moneyAmount,
            FirmBankingStatus firmBankingStatus,
            UUID uuid) {

        return new RequestedFirmBanking(
                requestedFirmBankingId.requestedFirmBankingId,
                fromBankName.fromBankName,
                fromBankAccountNumber.fromBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.moneyAmount,
                firmBankingStatus.firmBankingStatus,
                uuid
        );
    }

    @AllArgsConstructor(staticName = "from")
    public static class RequestedFirmBankingId {
        Long requestedFirmBankingId;

        public static RequestedFirmBankingId notAssigned() {
            return new RequestedFirmBankingId(null);
        }
    }

    @AllArgsConstructor(staticName = "from")
    public static class FromBankName {
        String fromBankName;
    }

    @AllArgsConstructor(staticName = "from")
    public static class FromBankAccountNumber {
        String fromBankAccountNumber;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ToBankName {
        String toBankName;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ToBankAccountNumber {
        String toBankAccountNumber;
    }

    @AllArgsConstructor(staticName = "from")
    public static class MoneyAmount {
        Long moneyAmount;
    }

    @AllArgsConstructor(staticName = "from")
    public static class FirmBankingStatus {
        int firmBankingStatus;
    }

    public ExternalFirmBankingRequest toExternalFirmBankingRequest() {
        return ExternalFirmBankingRequest.builder()
                .fromBankName(this.fromBankName)
                .fromBankAccountNumber(this.fromBankAccountNumber)
                .toBankName(this.toBankName)
                .toBankAccountNumber(this.toBankAccountNumber)
                .moneyAmount(this.moneyAmount)
                .build();
    }

    public void updateFirmBankingStatusToComplete() {
        this.firmBankingStatus = 1; // 요청 완료 상태로 업데이트
    }

    public void updateFirmBankingStatusToFail() {
        this.firmBankingStatus = 2; // 요청 실패 상태로 업데이트
    }
}
