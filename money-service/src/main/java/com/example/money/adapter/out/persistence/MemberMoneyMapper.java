package com.example.money.adapter.out.persistence;

import com.example.money.domain.MemberMoney;
import org.springframework.stereotype.Component;

@Component
public class MemberMoneyMapper {

    public MemberMoneyJpaEntity toJpaEntity(MemberMoney memberMoney) {
        return MemberMoneyJpaEntity.builder()
                .membershipId(memberMoney.getMembershipId())
                .balance(memberMoney.getBalance())
                .build();
    }

    public MemberMoney toDomain(MemberMoneyJpaEntity jpaEntity) {
        return MemberMoney.generateMemberMoney(
                MemberMoney.MemberMoneyId.from(jpaEntity.getId()),
                MemberMoney.MembershipId.from(jpaEntity.getMembershipId()),
                MemberMoney.AggregateIdentifier.from(jpaEntity.getAggregateIdentifier()),
                MemberMoney.Balance.from(jpaEntity.getBalance())
        );
    }

}
