package com.example.money.applicaiton.port.out;


import com.example.money.domain.MemberMoney;
import com.example.money.domain.MoneyChangingHistory;

import java.util.Optional;

public interface ChangeMoneyPort {

    MoneyChangingHistory createMoneyChangingHistory(MoneyChangingHistory moneyChanging);

    Optional<MemberMoney> getMemberMoneyByMembershipId(Long membershipId);

    void saveMemberMoney(MemberMoney memberMoney);

}
