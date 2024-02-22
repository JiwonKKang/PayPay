package org.example.money.adapter.out;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.money.domain.enums.MoneyChangingStatus;
import org.example.money.domain.enums.MoneyChangingType;

import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MoneyChangingHistoryJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long targetMembershipId;

    private MoneyChangingType changingType;

    private int changingAmount;

    private MoneyChangingStatus changingStatus;

    private String uuid;

    private Date createdAt;

    @Builder
    public MoneyChangingHistoryJpaEntity(Long id,
                                         Long targetMembershipId,
                                         MoneyChangingType changingType,
                                         int changingAmount,
                                         MoneyChangingStatus changingStatus,
                                         String uuid, Date createdAt) {
        this.id = id;
        this.targetMembershipId = targetMembershipId;
        this.changingType = changingType;
        this.changingAmount = changingAmount;
        this.changingStatus = changingStatus;
        this.uuid = uuid;
        this.createdAt = createdAt;
    }

}
