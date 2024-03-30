package com.example.remittance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Remittance {

    private final Long remittanceId;

    private final Long fromMembershipId;

    private final Long toMembershipId;

    private final String toBankName;

    private final String toBankAccountNumber;

    private final RemittanceRequestType remittanceRequestType;

    private final RemittanceRequestStatus remittanceRequestStatus;

    private final int moneyAmount;

    public static Remittance generateRemittance(
            Remittance.RemittanceId remittanceId,
            Remittance.FromMembershipId fromMembershipId,
            Remittance.ToMembershipId toMembershipId,
            Remittance.ToBankName toBankName,
            Remittance.ToBankAccountNumber toBankAccountNumber,
            Remittance.RemittanceType remittanceType,
            Remittance.RemittanceStatus remittanceStatus,
            Remittance.MoneyAmount moneyAmount
    ) {
        return new Remittance(
                remittanceId.remittanceId,
                fromMembershipId.fromMembershipId,
                toMembershipId.toMembershipId,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                remittanceType.remittanceRequestType,
                remittanceStatus.remittanceRequestStatus,
                moneyAmount.moneyAmount
        );
    }

    @AllArgsConstructor(staticName = "from")
    public static class RemittanceId {
        Long remittanceId;
        public static RemittanceId notAssigned() {
            return new RemittanceId(null);
        }
    }

    @AllArgsConstructor(staticName = "from")
    public static class FromMembershipId {
        Long fromMembershipId;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ToMembershipId {
        Long toMembershipId;
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
    public static class RemittanceType {
        RemittanceRequestType remittanceRequestType;
    }

    @AllArgsConstructor(staticName = "from")
    public static class RemittanceStatus {
        RemittanceRequestStatus remittanceRequestStatus;
    }

    @AllArgsConstructor(staticName = "from")
    public static class MoneyAmount
    {
        int moneyAmount;
    }

}
