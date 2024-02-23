package com.example.money.domain;

import com.example.money.domain.enums.MoneyChangingStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.money.domain.enums.MoneyChangingType;

import java.util.Date;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingHistory {

    private final Long moneyChangingId;
    private final Long targetMembershipId;
    private final MoneyChangingType changingType;
    private final int changingAmount;
    private MoneyChangingStatus changingStatus;
    private final String uuid;
    private final Date createdAt;

    public static MoneyChangingHistory generateMoneyChangingHistory(
            MoneyChangingId moneyChangingId,
            TargetMembershipId targetMembershipId,
            ChangingType changingType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingStatus changingStatus,
            Uuid uuid
    ){
        return new MoneyChangingHistory(
                moneyChangingId.moneyChangingId,
                targetMembershipId.targetMembershipId,
                changingType.changingType,
                changingMoneyAmount.changingMoneyAmount,
                changingStatus.changingMoneyStatus,
                uuid.uuid,
                new Date()
        );
    }

    @AllArgsConstructor(staticName = "from")
    public static class MoneyChangingId {
        Long moneyChangingId;
        public static MoneyChangingId notAssigned() {
            return new MoneyChangingId(null);
        }
    }

    @AllArgsConstructor(staticName = "from")
    public static class TargetMembershipId {
        Long targetMembershipId;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ChangingMoneyAmount {
        int changingMoneyAmount;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ChangingType {
        MoneyChangingType changingType;
    }

    @AllArgsConstructor(staticName = "from")
    public static class ChangingStatus {
        MoneyChangingStatus changingMoneyStatus;
    }

    @AllArgsConstructor(staticName = "from")
    public static class Uuid {
        String uuid;
    }

    public void changeStatus(MoneyChangingStatus status) {
        this.changingStatus = status;
    }


}
