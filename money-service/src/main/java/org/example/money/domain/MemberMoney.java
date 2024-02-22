package org.example.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberMoney {

    private final Long memberMoneyId;
    private final Long membershipId;
    private int balance;

    public static MemberMoney generateMemberMoney(
            MemberMoney.MemberMoneyId memberMoneyId,
            MemberMoney.MembershipId membershipId,
            MemberMoney.Balance balance
            ) {
        return new MemberMoney(
                memberMoneyId.memberMoneyId,
                membershipId.membershipId,
                balance.balance
        );
    }

    @AllArgsConstructor(staticName = "from")
    public static class MemberMoneyId {
        Long memberMoneyId;

        public static MemberMoneyId notAssigned() {
            return new MemberMoneyId(null);
        }
    }

    @AllArgsConstructor(staticName = "from")
    public static class MembershipId {
        Long membershipId;
    }

    @AllArgsConstructor(staticName = "from")
    public static class Balance {
        int balance;
    }

    public void increaseBalance(int amount) {
        this.balance += amount;
    }

    public void decreaseBalance(int amount) {
        if (this.balance < amount) throw new IllegalArgumentException("잔액이 부족합니다.");
        this.balance -= amount;
    }

}
