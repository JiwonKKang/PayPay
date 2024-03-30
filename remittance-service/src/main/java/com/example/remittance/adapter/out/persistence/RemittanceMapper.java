package com.example.remittance.adapter.out.persistence;

import com.example.remittance.domain.Remittance;
import org.springframework.stereotype.Component;

@Component
public class RemittanceMapper {

    public RemittanceJpaEntity toEntity(Remittance remittance) {
        return RemittanceJpaEntity.builder()
                .remittanceId(remittance.getRemittanceId())
                .fromMembershipId(remittance.getFromMembershipId())
                .toMembershipId(remittance.getToMembershipId())
                .toBankName(remittance.getToBankName())
                .toBankAccountNumber(remittance.getToBankAccountNumber())
                .remittanceRequestType(remittance.getRemittanceRequestType())
                .remittanceRequestStatus(remittance.getRemittanceRequestStatus())
                .moneyAmount(remittance.getMoneyAmount())
                .build();
    }

    public Remittance toDomain(RemittanceJpaEntity remittanceEntity) {
        return Remittance.generateRemittance(
                Remittance.RemittanceId.from(remittanceEntity.getRemittanceId()),
                Remittance.FromMembershipId.from(remittanceEntity.getFromMembershipId()),
                Remittance.ToMembershipId.from(remittanceEntity.getToMembershipId()),
                Remittance.ToBankName.from(remittanceEntity.getToBankName()),
                Remittance.ToBankAccountNumber.from(remittanceEntity.getToBankAccountNumber()),
                Remittance.RemittanceType.from(remittanceEntity.getRemittanceRequestType()),
                Remittance.RemittanceStatus.from(remittanceEntity.getRemittanceRequestStatus()),
                Remittance.MoneyAmount.from(remittanceEntity.getMoneyAmount())
        );
    }

}
