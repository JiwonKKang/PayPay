package com.example.money.adapter.out.persistence;

import com.example.money.domain.MoneyChangingHistory;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingHistoryMapper {


    public MoneyChangingHistory toDomain(MoneyChangingHistoryJpaEntity jpaEntity) {
        return MoneyChangingHistory.generateMoneyChangingHistory(
                MoneyChangingHistory.MoneyChangingId.from(jpaEntity.getId()),
                MoneyChangingHistory.TargetMembershipId.from(jpaEntity.getTargetMembershipId()),
                MoneyChangingHistory.ChangingType.from(jpaEntity.getChangingType()),
                MoneyChangingHistory.ChangingMoneyAmount.from(jpaEntity.getChangingAmount()),
                MoneyChangingHistory.ChangingStatus.from(jpaEntity.getChangingStatus()),
                MoneyChangingHistory.Uuid.from(jpaEntity.getUuid())
        );
    }

    public MoneyChangingHistoryJpaEntity toJpaEntity(MoneyChangingHistory moneyChanging) {
        return MoneyChangingHistoryJpaEntity.builder()
                .id(moneyChanging.getMoneyChangingId())
                .targetMembershipId(moneyChanging.getTargetMembershipId())
                .targetMembershipId(moneyChanging.getTargetMembershipId())
                .changingType(moneyChanging.getChangingType())
                .changingAmount(moneyChanging.getChangingAmount())
                .changingStatus(moneyChanging.getChangingStatus())
                .uuid(moneyChanging.getUuid())
                .build();
    }

}
