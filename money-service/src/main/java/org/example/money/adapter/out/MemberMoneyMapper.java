package org.example.money.adapter.out;

import org.example.money.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
public class MemberMoneyMapper {

    public MemberMoneyJpaEntity toJpaEntity(MemberMoney memberMoney) {
        return MemberMoneyJpaEntity.builder()
                .id(memberMoney.getMemberMoneyId())
                .membershipId(memberMoney.getMembershipId())
                .balance(memberMoney.getBalance())
                .build();
    }

    public MemberMoney toDomain(MemberMoneyJpaEntity jpaEntity) {
        return MemberMoney.generateMemberMoney(
                MemberMoney.MemberMoneyId.from(jpaEntity.getId()),
                MemberMoney.MembershipId.from(jpaEntity.getMembershipId()),
                MemberMoney.Balance.from(jpaEntity.getBalance())
        );
    }

}
